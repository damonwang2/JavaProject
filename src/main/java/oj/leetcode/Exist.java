package oj.leetcode;

public class Exist {
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {

        if (pos == word.length()) {
            return true;
        }

        // 1.越界 2.已访问 需要放回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }

        boolean flag = false;

        // 当前点可以匹配的话，继续深搜
        // 如果此路径不通，将路径上的点设置为未访问
        if (board[i][j] == word.charAt(pos)) {
            visited[i][j] = true;
            flag = search(board, i + 1, j, word, pos+1, visited) ||
                    search(board, i - 1, j, word, pos+1, visited) ||
                    search(board, i, j + 1, word, pos+1, visited) ||
                    search(board, i, j - 1, word, pos+1, visited);

            if (!flag) {
                visited[i][j] = false;
            }
        }

        return flag;
    }
}
