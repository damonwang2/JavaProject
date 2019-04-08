package onlineExamination.pdd;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;

        String[] strings = inStr.split("\\+");

        for(String str : strings){
            int num = Integer.parseInt(str);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
            sum += num;
        }
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            sb.append(entry.getKey() + "*" + entry.getValue() + "+");
        }
        String res = sb.toString();

        System.out.println(res.substring(0, res.length()-1));
        System.out.println(sum);
    }
}
