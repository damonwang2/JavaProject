package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SloveNQueen {

    private List<List<String>> res = new ArrayList<>();
    private final char POINT = '.';

    public List<List<String>> solveNQueens(int n) {
        // 索引表示列数，值表示行数
        List<Integer> usedRows = new ArrayList<>();
        backtracking(n, usedRows);
        return res;
    }

    public void backtracking(int n, List<Integer> usedRows) {
        int curCol = usedRows.size();
        
        // 递归边界：所有的皇后都安排好了
        if (curCol == n) {
            char[] chars = new char[n];
            List<String> list = new ArrayList<>();
            Arrays.fill(chars, POINT);
            for (int i = 0; i < curCol; i++) {
                int col = usedRows.get(i);
                chars[col] = 'Q';
                list.add(new String(chars));
                chars[col] = POINT;
            }
            res.add(list);
            return;
        }

        // curRow是给当前点分配的行，curCol是给当前点分配的列
        // 历史点，usedRows.get(col)的行，col是历史点的列
        for (int curRow = 0; curRow < n; curRow++) {
            boolean success = true;

            // 当前列的点和之前列的点：行不能冲突，对角线不能冲突
            // 有一个点冲突都不行
            for (int col = 0; col < curCol; col++) {
                if (usedRows.get(col) == curRow ||
                        Math.abs(curCol - col) == Math.abs(curRow - usedRows.get(col))) {
                    success = false;
                    break;
                }
            }

            if (success) {
                usedRows.add(curRow);
                backtracking(n, usedRows);
                usedRows.remove(usedRows.size() - 1);
            }
        }
    }
}
