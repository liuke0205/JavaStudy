package 笔试真题.快手;

import java.util.Scanner;

public class Main_最小代价爬楼梯 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(",");
        int n = strs.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1]+nums[i-1], dp[i-2]+nums[i-2]);
        }
        System.out.println(Math.min(dp[n-1]+ nums[n-1], dp[n-2]+nums[n-2]));
    }
}
