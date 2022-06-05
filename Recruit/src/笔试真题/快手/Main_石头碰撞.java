package 笔试真题.快手;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_石头碰撞 {
    /**
     * https://www.nowcoder.com/questionTerminal/9dd19c9305704138bdf83e2dffdcb4f4
     * 转化为01背包问题
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]] + nums[i-1]);
                }
            }
        }
        System.out.println(sum - 2 * dp[n][target]);

    }
}
