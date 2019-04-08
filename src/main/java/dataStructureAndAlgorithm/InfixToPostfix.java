package dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "1+(2-3)*4+9/5";
        String postfix = infixToPostfix(infix);
        System.out.println(postfix);
    }

    public static String infixToPostfix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> priorityMap = new HashMap<Character, Integer>();
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);


        for (char c : infix.toCharArray()) {

            // 操作数直接放入栈中
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if(c == ')') {
                // 右括号直接弹出，直到遇到左括号
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (stack.isEmpty() ||
                    c == '(' ||
                    stack.peek() == '(' ||
                    priorityMap.get(c) > priorityMap.get(stack.peek())){

                // 优先级高的压入栈，更先弹出栈
                stack.push(c);
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && priorityMap.get(c) <= priorityMap.get(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // 遇到末尾了
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
