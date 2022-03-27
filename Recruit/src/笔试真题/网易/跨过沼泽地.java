package 笔试真题.网易;

import java.util.Scanner;

public class 跨过沼泽地 {
    /**
     * 1代表沼泽地，0代表平地，小红从矩阵的左上角开始走，可以向左、向右或向下走
     * 当小红从沼泽地 -> 沼泽，或者从平地 -> 平地，需要花费1单元时间
     * 当小红从平地 -> 沼泽，或者从平地 -> 沼泽地，需要花费2单元时间
     *
     * 现在需要求最小花费时间？
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] != arr[i-1][0]){
                dp[i][0] = dp[i-1][0] + 2;
            }else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        for (int j = 1; j < m; j++) {
            if (arr[0][j] != arr[0][j-1]){
                dp[0][j] = dp[0][j-1] + 2;
            }else {
                dp[0][j] = dp[0][j-1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int num1 = (arr[i][j] == arr[i-1][j] ? dp[i-1][j] + 1 : dp[i-1][j] + 2);
                int num2 = (arr[i][j] == arr[i][j-1] ? dp[i][j-1] + 1 : dp[i][j-1] + 2);
                dp[i][j] = Math.min(num1, num2);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
