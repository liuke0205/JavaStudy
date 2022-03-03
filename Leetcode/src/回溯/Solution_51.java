package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/3 22:27
 */
public class Solution_51 {
    // 力扣51 https://leetcode-cn.com/problems/n-queens/
    List<List<String>> res;
    StringBuilder sb;
    char[][] chessboard;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtrcking(n, 0, chessboard);
        return res;
    }

    private void backtrcking(int n, int idx, char[][] chessboard) {
        if (idx == n){
            res.add(List2String(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(chessboard, idx, i)){
                chessboard[idx][i] = 'Q';
                backtrcking(n, idx + 1, chessboard);
                chessboard[idx][i] = '.';
            }
        }
    }

    private boolean check(char[][] chessboard, int i, int j) {
        // 检查j列有没有皇后
        for (int k = 0; k < chessboard.length; k++) {
            if (chessboard[k][j] == 'Q'){
                return false;
            }
        }

        //检查45度角有没有皇后
        for (int a = i, b = j; a >=0 && b >= 0 ; a--, b--) {
            if (chessboard[a][b] == 'Q'){
                return false;
            }
        }

        //检查135度角有没有皇后
        for (int a = i, b = j; a >=0 && b < chessboard.length ; a--, b++) {
            if (chessboard[a][b] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> List2String(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chessboard.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chessboard[0].length; j++) {
                sb.append(chessboard[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
