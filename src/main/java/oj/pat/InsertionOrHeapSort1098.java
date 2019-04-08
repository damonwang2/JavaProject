package oj.pat;

import java.util.Scanner;

public class InsertionOrHeapSort1098 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int[] original = new int[n];
		int[] later = new int[n];
		int i = 0, j;
		boolean isInsertion = true;
		for ( i = 0; i < n; i++) {
			original[i] = input.nextInt();
		}
		for ( i = 0; i < n; i++) {
			later[i] = input.nextInt();
		}
		//找到非升序的第一个下标，判断是否插入排序
		for ( i = 0; i < n; i++) {
			if(later[i] > later[i+1])
				break;
		}
		i++;
		for (j = i; j < n; j++) {
			if(original[j] != later[j])
				break;
		}
		
		if(j < n)
			isInsertion = false;
		
		if (isInsertion) {
			System.out.println("Insertion Sort");
			insertionSort(i, later);
		}
		
		else{
			System.out.println("Heap Sort");
			heapSort(later);
		}
		
		for (int k = 0; k < n-1; k++) {
			System.out.print(later[k] + " ");
		}
		System.out.print(later[n-1]);
	}

	private static void heapSort(int[] a) {
		// TODO 自动生成的方法存根
		int i, child, temp;
		for (i = a.length - 1; i > 0; i--) {
			if(a[0] > a[i]){
				temp = a[0];
				a[0] = a[i];
				a[i] = temp;
				break;
			}
		}
		temp = a[0];
		int j;
		i--;
		for (j = 0; 2 * j + 1 <= i; j = child) {
			child = 2 * j + 1;
			if(child + 1 <= i  &&  a[child] < a[child + 1])
				child++;
			if(a[child] > temp)
				a[j] = a[child];
			else
				break;
		}
		a[j] = temp;
	}

	private static void insertionSort(int i, int[] later) {
		// TODO 自动生成的方法存根
		int j = 0;
		int temp = later[i];
		for ( ; j < i; j++)
			//找到第一个比later[i]大的值
			if(later[j] > later[i])
				break;
		
		while (i > j)
			later[i] = later[--i];
		later[j] = temp;
	}
}