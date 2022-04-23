package 笔试真题.腾讯;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/24 0:36
 */
public class Solution_假期 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][2];
        dp[0][0] = arr1[0];
        dp[0][1] = arr2[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + arr1[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + arr2[i]);
        }
        System.out.println(n - Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
