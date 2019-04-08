package oj.pat;

import java.util.LinkedList;

import java.util.Queue;

public class Emergency {
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[][] a = { {0,1,1}, {0,2,2}, {0,3,1}, {1,2,1}, {2,4,1}, {3,4,1} };
		int C2 = 2;
		int N = 5;
		int[] teams = {1, 2, 1, 5, 3};
		System.out.println(a.length);
		int sum = BFS(a, C2, teams);
		System.out.println("BFS:" + sum);
		sum = DFS(a, C2, teams);
		System.out.println("DFS:" + sum);
	}

	private static int DFS(int[][] a, int c2, int[] teams) {
		// TODO �Զ����ɵķ������
		boolean[] visited = new boolean[teams.length];
		int sum = 0;
		DFS_(c2, visited, a, teams, sum);
		return sum;
	}

	private static  int DFS_(int current, boolean[] visited, int[][] a, int[] teams, int sum) {
		// TODO �Զ����ɵķ������
		visited[current] = true;
		for (int j = 0; j < a.length; j++) {
        	if(a[j][0] == current  && visited[ a[j][1] ] == false){
        		visited[a[j][1]] = true;
        		sum += DFS_(a[j][1], visited, a, teams, sum);
        		System.out.println("sum:" + sum);
        	}
		}
		
		for (int j = 0; j < a.length; j++) {
        	if(a[j][1] == current  && visited[ a[j][0] ] == false){
        		visited[a[j][0]] = true;
        		sum += DFS_(a[j][0], visited, a, teams, sum);
        		System.out.println("sum:" + sum);
        	}
		}
		System.out.println("visited" + current + "\tteams[" + current + "]:" + teams[current]);
		return sum;
	}

	private static int BFS(int[][] a, int C2, int[] teams) {
		// TODO �Զ����ɵķ������
		Queue<Integer> q = new LinkedList<Integer>();
        q.add(C2);
        //********ĳ��Ԫ�صĸ���****
        int count = 1;
        int sum = 0;
        boolean[] is = new boolean[teams.length];
        while(!q.isEmpty()){
            //********pop()���������У���void*******
            int current = q.remove();
            count--;
            
            for (int j = 0; j < a.length; j++) {
            	if(a[j][0] == current  && is[ a[j][1] ] == false){
            		q.add(a[j][1]);
            		is[a[j][1]] = true;
            		sum += teams[a[j][1]];
            	}
			}
            
            for (int j = 0; j < a.length; j++) {
            	if(a[j][1] == current  && is[a[j][1]] == false){
            		q.add(a[j][0]);
            		is[a[j][0]] = true;
            		sum += teams[a[j][0]];
            	}
			}
        }//while
        
        return sum;
	}

}
