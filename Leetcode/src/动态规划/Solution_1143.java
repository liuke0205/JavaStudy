package 动态规划;

/**
 * @author liuke
 * @date 2022/2/16 23:49
 */
public class Solution_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] 代表text1[0..i] 和 text2[0...j] 的最长公共自序列
        // base case
        /*
        dp[i][j] = (text1[i] == text2[j]) ? (dp[i-1][j-1] + 1) :
            max(dp[i-1][j], dp[i][j])
         */
        int length1 = text1.length(), length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }
}