package 动态规划;

/**
 * @author liuke
 * @date 2022/3/4 23:36
 */
public class Solution_198打家劫舍 {
    public int rob(int[] nums) {
        // 1.dp[i]代表投前i个房屋获得的最大价值
        // 2.公式：dp[i] = max(dp[i-2] + nums[i], dp[i-1]);
        // 3.初始值: dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
