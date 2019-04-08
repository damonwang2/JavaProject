package onlineExamination.meituan2018_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int height = 0;
    private static int maxHeight = 0;
    private static TreeNode[] treeNodes;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        treeNodes = new TreeNode[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            treeNodes[i] = new TreeNode();
        }

        if (n == 0 || n == 1) {
            System.out.println(0);
            return;
        }

        // 获取对应n条边，构建树
        for (int i = 1; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            treeNodes[start].next.add(end);
            treeNodes[end].next.add(start);
        }

        // 遍历树
        traverse(1);

        System.out.println(2 * n - 2 - maxHeight);
    }

    public static void traverse(int i) {
        visited[i] = true;
        TreeNode treeNode = treeNodes[i];

        height++;
        for (Integer child: treeNode.next) {
            if (!visited[child]) {
                traverse(child);
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }
        }
        height--;
    }
}

class TreeNode {
    // 保存孩子节点的索引
    List<Integer> next = new ArrayList<>();
}
