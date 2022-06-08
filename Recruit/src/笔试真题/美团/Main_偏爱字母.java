package 笔试真题.美团;

import java.util.Scanner;

public class Main_偏爱字母 {
    /**
     * https://www.nowcoder.com/questionTerminal/51d326be37b948ae8d9b9f4aefccbd45
     * 思路：将E->1,F->-1，求最大连续序列的和【动态规划】
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] chars = scanner.next().toCharArray();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'E'){
                nums[i] = 1;
            }else {
                nums[i] = -1;
            }
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
