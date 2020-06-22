package oj.leetcode;

import java.util.HashSet;
import java.util.List;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            // 一次循环检验三次
            // 利用i，j进行变换
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Set.add()插入已有元素将会返回false
                if (board[i][j] != '.' && !rows.add(board[i][j])) { return false; }
                if (board[j][i] != '.' && !columns.add(board[j][i])) { return false; }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

}
