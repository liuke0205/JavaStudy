package 动态规划;

/**
 * @author liuke
 * @date 2022/2/20 22:13
 */
public class Solution_96不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
