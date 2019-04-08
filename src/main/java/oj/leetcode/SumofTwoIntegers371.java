package oj.leetcode;

import java.util.Scanner;

public class SumofTwoIntegers371 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		getSum(a, b);
	}
	public static int getSum(int a, int b) {
        while (b != 0) {
        	//��������Զ����Ƶ�
        	//�����ǽ�λ
            int c = a ^ b;
            //��λ����
            b = (a & b) << 1;
            a = c;
            System.out.println(a);
        }
        return a;
    }
}
