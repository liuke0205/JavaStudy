import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/2/24 22:36
 */
public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        //1. dp[j] 代表 凑成j所需的最小硬币个数
        //2. 公式：dp[j] = Min(dp[j], dp[j - nums[i]])
        //3. 初始化：dp[0] = 0, 其他的呢？ max
        //4. 遍历顺序： 组合数-> 外层是物品，内层是target；完全背包->内层正序
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
