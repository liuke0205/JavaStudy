package 动态规划;

/**
 * @author liuke
 * @date 2022/3/4 23:52
 */
public class Solution_213打家劫舍II {
    public int rob(int[] nums) {
        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length-2));
    }

    public int rob(int[] nums, int left, int right) {
        int len = right - left + 1;
        if (right - left == 0){
            return nums[left];
        }
        int[] dp = new int[len];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i + left], dp[i-1]);
        }
        return dp[len - 1];
    }
}
