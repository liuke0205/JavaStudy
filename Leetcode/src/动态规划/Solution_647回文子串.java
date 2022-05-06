package 动态规划;

/**
 * @author liuke
 * @date 2022/3/3 23:32
 */
public class Solution_647回文子串 {
    //力扣647 https://leetcode-cn.com/problems/palindromic-substrings/
    public int countSubstrings(String s) {
        // 1. dp[i][j] 代表s[i..j]是否为回文串
        // 2. dp[i][j] = (s[i] != s[j]) ? false : (j - i <= 2 ? true : dp[i+1][j-1]);
        // 3. 初始值:dp[i][i] = true;
        // 4. 遍历顺序：从下向上，从左到右
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(j - i <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                res += (dp[i][j] ? 1 : 0);
            }
        }
        return res;
    }
}
