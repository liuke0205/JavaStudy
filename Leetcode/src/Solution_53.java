/**
 * @author liuke
 * @date 2022/2/16 23:43
 */
public class Solution_53 {
    public int maxSubArray(int[] nums) {
        //base case dp[i] = 0
        //dp[i] 代表nums[0...i]的最大连续子数组
        //dp[i] = Math.max(nums[i], 0) + dp[i-1]
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i-1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}