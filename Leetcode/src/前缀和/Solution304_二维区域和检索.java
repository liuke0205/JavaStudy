package 前缀和;

/**
 * @author liuke
 * @date 2022/5/13 14:38
 */
public class Solution304_二维区域和检索 {

}

class NumMatrix {
    int[][] matrix;
    int[][] pre;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        pre = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[0].length; j++) {
                pre[i+1][j+1] = pre[i][j+1] + pre[i+1][j] - pre[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2+1][col2+1] - pre[row1][col2+1] - pre[row2+1][col1] + pre[row1][col1];
    }
}