package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {

    //距离为M表示不相邻，
    static int M = 10000;

    public static void main(String[] args) {
        int[][] weight = {
                {0,10,M,30,100},
                {M,0,50,M,M},
                {M,M,0,M,10},
                {M,M,20,0,60},
                {M,M,M,M,0}
        };

        BfsTraverse(weight);

        DFSTraverse(weight);

        int start=0;
        int[] shortestPathLength = dijkstra(weight,start);

        for(int i = 0;i < shortestPathLength.length;i++){
            System.out.print(shortestPathLength[i] + "\t");
        }
    }

    public static int[] dijkstra(int[][] weight, int start){
        //检查null和长度0
        if(weight == null || weight.length == 0){
            return null;
        }

        int n = weight.length;
        //shortestPathLength表示长度，path路径
        int[] shortestPathLength = new int[n];
        int[] path = new int[n];
        boolean[] visited = new boolean[n];
        visited[start] = true;

        for(int i = 0; i < n; i++){
            path[i] = start;
            shortestPathLength[i] = weight[start][i];
        }

        //循环n-1次，因为start结果不用
        System.out.println("循环n-1次");
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            int nextVertex = n;

            for(int j = 0; j < n; j++){
                if(!visited[j] && shortestPathLength[j] < min){
                    min = shortestPathLength[j];
                    nextVertex = j;
                }
            }

            visited[nextVertex] = true;


            for(int j = 0; j < n; j++){
                if(!visited[j] && (shortestPathLength[nextVertex] + weight[nextVertex][j]) < shortestPathLength[j]){
                    shortestPathLength[j] = shortestPathLength[nextVertex] + weight[nextVertex][j];
                    path[j] = nextVertex;
                }
            }
        }
        return shortestPathLength;
    }

    public static void BfsTraverse(int[][] weight){

        if(weight == null){
            return;
        }

        //节点个数
        int n = weight.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        //对每个节点进行一次BFS，用于处理非连通图
        //连通图一次BFS可以访问结束
        for (int i = 0; i < n; i++){

            //BFS主代码
            if(!visited[i]){
                //访问，visited设置true，入队列三件事同时进行
                list.add(i);
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()){
                    //访问队头节点
                    int current = queue.poll();

                    for (int j = 0; j < n; j++){
                        //添加下一个节点到队列中
                        //条件：要相邻；未访问过
                        if(!visited[j] && weight[current][j] != M){
                            //BFS要在这里设置true，不设置的话可能会被再次访问。
                            // 因为DFS和层序不会，因为DFS马上就会递归去执行，而层序是不会往上走的
                            queue.add(j);
                            list.add(j);
                            visited[j] = true;
                        }
                    }
                }//一次BFS结束

            }
        }
        System.out.println(list);
    }

    public static void DFSTraverse(int[][] weight){
        if(weight == null){
            return;
        }
        int n = weight.length;
        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                DFS(weight, i, visited, list);
            }
        }
        System.out.println(list);
    }

    public static void DFS(int[][] weight, int i, boolean[] visited, ArrayList<Integer> list) {
        visited[i] = true;
        list.add(i);

        for(int j = 0; j < weight.length; j++){
            if(!visited[j] && weight[i][j] != M){
                DFS(weight, j, visited, list);
            }
        }
    }
}
