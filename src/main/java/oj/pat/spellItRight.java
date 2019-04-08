package oj.pat;

import java.util.Scanner;
import java.util.Stack;

public class spellItRight {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = n;
		int sum = 0;
		while( n != 0){
			sum += n % 10;
			n = n / 10;
		}
		
		Stack<String> s = new Stack<String>();
		
//		ArrayList<String> s = new ArrayList<String>();
		while(sum != 0){
			n = sum % 10;
			sum = sum / 10;
			if( n == 0)
				s.add("zero");
			else if( n == 1)
				s.add("one");
			else if( n ==2)
				s.add("two");
			else if( n == 3)
				s.add("three");
			else if( n == 4)
				s.add("four");
			else if( n == 5)
				s.add("five");
			else if( n == 6)
				s.add("six");
			else if( n == 7)
				s.add("seven");
			else if( n == 8)
				s.add("eight");
			else
				s.add("nine");
		}
		if( m == 0)
			System.out.println("zero");
		else{	
//			for(int i = s.size() - 1; i > 0; i--)
//				System.out.print( s.get(i) + " ");
//			System.out.print(s.get(0));
			while( !s.isEmpty() ){
				if(s.size() > 1)
					System.out.print(s.pop() + " ");
				else
					System.out.print(s.pop());
				
			}
		}
	}

}
