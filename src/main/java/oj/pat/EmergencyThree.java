package oj.pat;

import java.util.Scanner;

public class EmergencyThree {


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
	    int N = input.nextInt();
	    int M = input.nextInt();
	    int C1 = input.nextInt();
	    int C2 = input.nextInt();
	    int in = 2147;
	    int[] teams = new int[N];
	    int[] pathcount = new int[N];
	    int[] amount = new int[N];
	    boolean[] isVisited = new boolean[N];
	    int[][] adj = new int[N][N];
	    int[] D = new int[N];
	    
	    //***********��ʼ��********
	    for (int i = 0; i < N; i++){ 
	    	teams[i] = input.nextInt();
	        D[i] = in;  
	        pathcount[i] = 1;  
	        isVisited[i] = false;  
	        for (int j = 0; j < N; j++)  
	            adj[i][j] = in;  
	    }//for
	    
	    for (int i = 0; i < M; i++) {
	    	int m = input.nextInt();
	    	int n = input.nextInt();
	    	int t = input.nextInt();
	    	adj[m][n] = t;
	    	adj[n][m] = t;
	    }//for
	    
	    //*********���㷨*********
	    D[C1] = 0;  
	    amount[C1] = teams[C1];  
	    isVisited[C1] = true;  
	    int newP = C1;  
	    while (newP != C2){  
	        for (int i = 0; i < N; i++){  
	            if (isVisited[i] == false){  
	                if (D[i] > D[newP] + adj[newP][i]){  
	                    D[i] = D[newP] + adj[newP][i];  
	                    amount[i] = amount[newP] + teams[i];
	                    //c1��i �� c1��NewP + newP��i������pathcount[i] = pathcount[newP];
	                    pathcount[i] = pathcount[newP];
	                }  
	                else if (D[i] == D[newP] + adj[newP][i]){
	                	//ԭ���İ취�����µĹ�newP�İ취
	                    pathcount[i] += pathcount[newP];
	                    //ѡ������·���ж��������һ����
	                    if (amount[i] < amount[newP] + teams[i])
	                        amount[i] = amount[newP] + teams[i];
	                }  
	            }//if
	        }//for    
	        int min = in;  
	        for (int i = 0; i < N; i++){  
	            if (isVisited[i] == false && D[i] < min){
	                min = D[i];
	                newP = i;
	            }  
	        }  
	        isVisited[newP] = true;  
	    }//while
	    
		System.out.println( pathcount[C2] + " " + amount[C2] );
	}

}
