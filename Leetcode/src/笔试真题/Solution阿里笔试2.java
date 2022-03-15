package 笔试真题;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/15 9:43
 */
public class Solution阿里笔试2 {
    /*
    题目描述：n行m列的矩阵，1表示人，0表示聚光灯。每个聚光灯可以朝着上、下、左、右四个方向照射（照射距离无穷大）
    若某个方向站着一个人，那么小红就得1分。
    现在，需要计算小红一共能得多少分？

    测试用例：
    2 4
    0 1 0 0
    1 0 1 0
     */

    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1){
                    dfs_up(arr, i-1, j);
                    dfs_down(arr, i+1, j);
                    dfs_left(arr, i, j-1);
                    dfs_right(arr, i, j+1);
                }
            }
        }
        System.out.println(res);
    }
    private static void dfs_right(int[][] arr, int i, int j) {
        if (j >= arr[0].length || arr[i][j] == 1){
            return;
        }
        if (arr[i][j] == 0){
            res++;
        }
        dfs_right(arr, i, j + 1);
    }

    private static void dfs_left(int[][] arr, int i, int j) {
        if (j < 0 || arr[i][j] == 1){
            return;
        }
        if (arr[i][j] == 0){
            res++;
        }
        dfs_left(arr, i, j - 1);
    }

    private static void dfs_down(int[][] arr, int i, int j) {
        if (i >= arr.length || arr[i][j] == 1){
            return;
        }
        if (arr[i][j] == 0){
            res++;
        }
        dfs_down(arr, i+1, j);
    }

    private static void dfs_up(int[][] arr, int i, int j) {
        if (i < 0 || arr[i][j] == 1){
            return;
        }
        if (arr[i][j] == 0){
            res++;
        }
        dfs_up(arr, i-1, j);
    }
}
