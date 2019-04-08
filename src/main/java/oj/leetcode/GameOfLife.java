package oj.leetcode;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        // 采用0, 1, 2, 3四个数字来表示状态，下面用二进制表示
        // - 00  dead (next) <- dead (current)
        // - 01  dead (next) <- live (current)
        // - 10  live (next) <- dead (current)
        // - 11  live (next) <- live (current)
        // 一个数字表示了当前状态(低位)和下一个状态(高位)
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = getLiveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && liveNeighbors >= 2 && liveNeighbors <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int getLiveNeighbors(int[][] board, int m, int n, int i, int j) {
        int liveNeighbors = 0;

        // 计算周围live(低位为1)的数量。这里面包括了自己，后面会减去
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                liveNeighbors += board[x][y] & 1;
            }
        }

        liveNeighbors -= board[i][j] & 1;
        return liveNeighbors;
    }
}
