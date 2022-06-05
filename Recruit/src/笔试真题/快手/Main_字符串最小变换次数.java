package 笔试真题.快手;

import java.util.Scanner;

public class Main_字符串最小变换次数 {
    /**
     * https://www.nowcoder.com/questionTerminal/2561ad26e8804cf8801926f03708ef03
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) != s2.charAt(j-1)){
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
