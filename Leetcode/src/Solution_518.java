/**
 * @author liuke
 * @date 2022/2/23 22:55
 */
public class Solution_518 {
    public int change(int amount, int[] coins) {
        //1. dp[j] 代表组合成j的组合数
        //2. dp[j] += dp[j- coins[i]]
        //3. 遍历顺序 外层 是物品正序， 内层是容量正序（完全背包）
        //4. 初始化 dp[0] = 1
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
