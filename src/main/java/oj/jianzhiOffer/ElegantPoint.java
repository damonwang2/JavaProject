package oj.jianzhiOffer;

import java.util.Scanner;

public class ElegantPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int radiusSquare = input.nextInt();
        int a = 0;
        int b = (int) Math.sqrt(radiusSquare);
        int count = 0;

        while (a <= b){
            int sum = a * a + b * b;
            if(sum == radiusSquare){
                if(a == 0 || a == b)
                    count += 4;
                else
                    count += 8;
                a++;
                b--;
            }else if(sum < radiusSquare){
                a++;
            }else{
                b--;
            }
        }
        System.out.println(count);
    }
}
