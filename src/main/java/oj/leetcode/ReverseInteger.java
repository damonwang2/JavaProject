package oj.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		// 两个正数相乘，溢出可能还是正数
		System.out.println(964632435 * 10);
//		int x = -2147483648;
//
//		long res = x;
//		boolean flag = true;
//		if(res < 0){
//			flag = false;
//			res = -res;
//		}
//
//		while(res % 10 == 0)
//			res = res / 10;
//		System.out.println(res);
//		Long i = new Long(res);
//		String s = i.toString();
//		StringBuffer sb = new StringBuffer(s);
//		s = s = sb.reverse().toString();
//
//        res = Long.parseLong(s);
//
//        System.out.println(res);
//        if(res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE);
	}

	public static int reverse(int x) {
		long res = 0;
		while(x!=0) {
			//每次取末尾数字
			int tmp = x%10;
			res = res*10 + tmp;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}

		return new Long(res).intValue();
	}

}
