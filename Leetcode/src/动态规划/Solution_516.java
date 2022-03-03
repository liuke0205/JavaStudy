package 动态规划;

import com.sun.scenario.animation.shared.ClipEnvelope;

/**
 * @author liuke
 * @date 2022/3/3 23:10
 */
public class Solution_516 {
    // 力扣516 https://leetcode-cn.com/problems/longest-palindromic-subsequence/
    public int longestPalindromeSubseq(String s) {
        // 1. dp[i][j]代表 s[i...j]的最长回文串
        // 2. dp[i][j] = (s[i] == s[j]) ? (dp[i+1][j-1] + 2) : max(dp[i+1][j], dp[i][j-1]);
        // 3. 初始值： dp[i][i] = 1;
        // 4. 遍历顺序 从下往上；从左到右
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len-1; i >=0 ; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()];
    }
}
