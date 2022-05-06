package 动态规划;

/**
 * @author liuke
 * @date 2022/3/5 0:18
 */
public class Solution_121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        //1.dp[i][0] 代表 第i天持有股票的最大价值; dp[i][1] 代表 第i天不持有股票的最大价值；
        //2.公式：dp[i][0] = max(dp[i-1][0], dp[i-1][1] - nums[i]); dp[i][1] = max(dp[i-1][1], nums[i]);
        //3.初始值：dp[0][0] = -nums[0]; dp[0][1] = 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
