import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/2/24 23:17
 */
public class Solution_279 {

    public int numSquares(int n) {
        // 1.dp[j] 代表 j的完全平方数的最少数量是dp[j]
        // 2.公式：dp[j] = min(dp[j], dp[j - i * i])
        // 3.dp[0] = 0  其他 max
        // 4.  遍历顺序：由于是组合问题->外层是物品，内层是target；由于是完全背包问题->内层是正序遍历
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
