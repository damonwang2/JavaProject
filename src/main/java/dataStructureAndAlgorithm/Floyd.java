package dataStructureAndAlgorithm;

public class Floyd {
    //M表示不相连，也可以用Integer.MAX_VALUE
    static int M = 10000;

    public static void main(String[] args) {
        //采用参数传递（而非返回值）来获得结果
        int[][] weight = {
                {0,10,M,30,100},
                {M,0,50,M,M},
                {M,M,0,M,10},
                {M,M,20,0,60},
                {M,M,M,M,0}
        };
        int n = weight.length;
        int[][] path = new int[n][n];
        floyd(weight, path);
    }

    public static void floyd(int[][] weights, int[][] path){
        // 初始化
        int n = weights.length;
        if(n == 0){
            System.out.println("the number of vertex is 0");
            return;
        }
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = weights[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }

        // 计算最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    // 如果M用Integer.MAX_VALUE表示，则不能直接相加，否则会导致溢出
                    int tmp = (dist[i][k]==M || dist[k][j]==M) ? M : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }

                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.println();
        }

    }
}
