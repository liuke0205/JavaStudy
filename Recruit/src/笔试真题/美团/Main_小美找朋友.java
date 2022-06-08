package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/8 23:41
 */
public class Main_小美找朋友 {
    /**
     * https://www.nowcoder.com/questionTerminal/58aa83aa37f14d11a51eb87b3813bbc6
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[] nums1 = scanner.next().toCharArray();
        char[] nums2 = scanner.next().toCharArray();
        fun2(nums1, nums2, n, m);
    }

    public static void fun2(char[] nums1, char[] nums2, int n, int m) {
        int i = 0, j = 0;
        long sum = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                sum += i+1;
                j++;
            }
            i++;
        }
        if (j == nums2.length){
            System.out.println("Yes");
            System.out.println(sum);
        }else {
            System.out.println("No");
        }
    }

    /**
     * 求最长公共子序列，但是只能过60% 后面就OOM
     * @param nums1
     * @param nums2
     * @param n
     * @param m
     */
    public static void fun1(char[] nums1, char[] nums2, int n, int m){
        int[][] dp = new int[n][m];
        // 1.初始化
        for (int i = 0; i < m; i++) {
            if (nums1[0] == nums2[i]){
                dp[0][i] = 1;
            }
            if (i > 0 && dp[0][i-1] == 1){
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums2[0] == nums1[i]){
                dp[i][0] = 1;
            }
            if (i > 0 && dp[i-1][0] == 1){
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if (dp[n-1][m-1] != m){
            System.out.println("No");
            return;
        }else {
            System.out.println("Yes");
            long sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[j][i] == i + 1){
                        sum += j + 1;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
