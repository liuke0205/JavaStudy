package 动态规划;

/**
 * @author liuke
 * @date 2022/2/28 22:53
 */
public class Solution_115不同的子序列 {
    public int numDistinct(String s, String t) {
        // 1.dp[i][j] 表示 s[0...i] 中出现 t[0...j]的次数
        // 2.dp[i][j] = (s[i] == t[j]) ? (dp[i-1][j-1] + dp[i-1][j]) : dp[i-1][j];
        // 3.初始化dp[0][j] = 0, dp[i][0] = 1
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length()+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
