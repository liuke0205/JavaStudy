package 笔试真题.京东;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/21 23:37
 */
public class Main_上台阶 {
    public static void main(String[] args) {

    }
    public int countWays(int n) {
        if (n < 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
