package oj.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = -2147483648;
		
		long res = x;
		boolean flag = true;
		if(res < 0){
			flag = false;
			res = -res;
		}
			
		while(res % 10 == 0)
			res = res / 10;
		System.out.println(res);	
		Long i = new Long(res);
		String s = i.toString();
		StringBuffer sb = new StringBuffer(s);
		s = s = sb.reverse().toString();
		
        res = Long.parseLong(s);
        
        System.out.println(res);
        if(res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE);
	}

}
