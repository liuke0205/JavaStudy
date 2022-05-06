package 动态规划;

import java.util.Arrays;

public class Solution_300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        //base case dp[] = 1
        //dp[i] 代表以nums[0...i]的最长递增序列
        //dp[i] = max(dp[j] + 1) nums[i] > nums[j]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
