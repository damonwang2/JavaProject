package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class JumpFloor {
    public static void main(String[] args) {
        int a = 5;
        if(a > 0)
            System.out.println("大于");
        System.out.println("hello world");
        List<Integer> list = new ArrayList<Integer>();
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(JumpFloorII(3));
    }
    public static int JumpFloorII(int number) {
        //采用动态规划，递推式F(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(0),
        //f(n-1) = f(n-2) + f(n-3) + ... + f(0)
        //所以f(n) = 2 * f(n-1)
        if(number <= 0)
            return 0;
        if(number == 1)
            return 1;
        return 1 << (number - 1);
    }
}
