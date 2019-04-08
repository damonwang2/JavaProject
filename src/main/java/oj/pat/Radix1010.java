package oj.pat;

import java.util.Scanner;

public class Radix1010 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		String n = input.next();
		String m = input.next();
		
		int tag = input.nextInt();
		long radix = input.nextLong();
		long minRadix = 0;
		long maxRadix;
		long nValue = 0;
		long mValue = 0;
		
		if(tag == 2){
			String t = n;
			n = m;
			m = t;
		}
		
		//**********��n��index���Ʊ��ʮ����
		nValue = parseLong(n, radix);
		
		for(int i = 0; i < m.length(); i++){
			if( Cal(m.charAt(i)) > minRadix)     
	            minRadix = Cal(m.charAt(i)) + 1;
		}
		maxRadix = nValue  + 1;
		
		while(minRadix < maxRadix){
			long midRadix = (minRadix + maxRadix) / 2;
			mValue = parseLong(m, midRadix);
			if(mValue > nValue  ||  mValue == -1){
				maxRadix = midRadix - 1;
			}//if
			else if(mValue < nValue)
				minRadix = midRadix + 1;
			else{
				System.out.print(midRadix);
				return;
			}
		}//for
			
		System.out.println("Impossible");
		
	}//main

	
	private static long parseLong(String s, long radix) {
		int i;    
	    long result = 0;    
	    for ( i = 0; i < s.length(); i++){    
	        result *= radix;    
	        result += Cal(s.charAt(i));    
	        if (result < 0)
	            return -1;
	    }    
	    return result;
	}

	private static long Cal(char c) {
		 if (c >= '0' && c <= '9')
			 return (c -'0'); 
		 else    
		     return (c - 'a' + 10);  
	}

}
