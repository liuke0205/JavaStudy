import java.util.Map;

/**
 * @author liuke
 * @date 2022/2/20 21:42
 */
public class Solution_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(Math.max(dp[i-j] * j, j * (i-j)), dp[i]);
            }
        }
        return dp[n];
    }
}
