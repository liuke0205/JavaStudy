package 动态规划;

/**
 * @author liuke
 * @date 2022/2/24 22:24
 */
public class Solution_377组合总数IV {
    public int combinationSum4(int[] nums, int target) {
        // 1.dp[j] 代表组合成j的组合数有dp[j]种
        // 2.公式 dp[j] += dp[j - nums[i]]
        // 3.初始化 dp[0] = 1
        // 4.遍历顺序：由于是求排列数，所以外层是target 内层是物品；由于是完全背包 外层正序
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++) {
            for (int num : nums) {
                if (j - num >= 0) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
}
