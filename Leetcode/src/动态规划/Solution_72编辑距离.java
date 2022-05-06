package 动态规划;

/**
 * @author liuke
 * @date 2022/2/17 0:00
 */
public class Solution_72编辑距离 {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 代表word1[0...i] 和 word2[0...j] 之间的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}