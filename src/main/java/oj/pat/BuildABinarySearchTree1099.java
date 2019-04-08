package oj.pat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildABinarySearchTree1099 {

	static int k = 0;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] a = new int[n][3];
		int value[] = new int[n];
		int output[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i][0] = input.nextInt();
			a[i][1] = input.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			value[i] = input.nextInt();
		}
		
//		Arrays.sort(value);
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i; j < n; j++) {
				if(value[j] < value[min])
					min = j;
			}
			int temp = value[min];
			value[min] = value[i];
			value[i] = temp;
		}
		inOrder(0, a);
		
		for (int i = 0; i < n; i++) {
			int s = a[i][2];
			output[s] = value[i];
		}
		
		//����α�����������ȡ�
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int count = 1;
		int index = 0;
		while( !q.isEmpty() ){
			Integer i = q.poll();
			value[index++] = i;
			count--;
			if(a[i][0] != -1)
				q.add(a[i][0]);
			if(a[i][1] != -1)
				q.add(a[i][1]);
			if(count == 0)
				count = q.size();
		}
		for(int i = 0; i < n-1; i++)
			System.out.print(output[value[i]] + " ");
		System.out.print(output[n-1]);
	}

	private static void inOrder(int i, int[][] a) {
		// TODO �Զ����ɵķ������
		int left = a[i][0];
		int right = a[i][1];

		if(left != -1)
			inOrder(left, a);
		visit(i, a);
		if(right != -1)
			inOrder(right, a);
	}

	private static void visit(int i, int[][] a) {
		// TODO �Զ����ɵķ������
		a[k++][2] = i;
	}
}