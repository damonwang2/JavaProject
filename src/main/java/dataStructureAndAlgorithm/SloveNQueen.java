package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SloveNQueen {

    private List<List<String>> res = new ArrayList<>();
    private final char POINT = '.';

    public List<List<String>> solveNQueens(int n) {
        // 索引表示列数，值表示行数
        List<Integer> row2col = new ArrayList<>();
        backtracking(n, row2col);
        return res;
    }

    public void backtracking(int n, List<Integer> row2col) {
        int trackColSize = row2col.size();
        
        // 递归边界：所有的皇后都安排好了
        if (trackColSize == n) {
            char[] chars = new char[n];
            List<String> list = new ArrayList<>();
            Arrays.fill(chars, POINT);
            for (int i = 0; i < trackColSize; i++) {
                int col = row2col.get(i);
                chars[col] = 'Q';
                list.add(new String(chars));
                chars[col] = POINT;
            }
            res.add(list);
            return;
        }

        // curRow是给当前点分配的行，curCol是给当前点分配的列
        // 历史点，row2col.get(col)的行，col是历史点的列
        for (int curRow = 0; curRow < n; curRow++) {
            boolean success = true;

            // 当前列的点和之前列的点：行不能冲突，对角线不能冲突
            // 有一个点冲突都不行
            for (int col = 0; col < trackColSize; col++) {
                if (row2col.get(col) == curRow ||
                        Math.abs(trackColSize - col) == Math.abs(curRow - row2col.get(col))) {
                    success = false;
                    break;
                }
            }

            if (success) {
                row2col.add(curRow);
                backtracking(n, row2col);
                row2col.remove(row2col.size() - 1);
            }
        }
    }
}
