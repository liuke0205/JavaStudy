package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/7 23:33
 */
public class Main_回转寿司 {
    /**
     * https://www.nowcoder.com/questionTerminal/5a2a527f68b6434ba0b4faadcdc97812
     *
     * 思路：循环最大连续子段和 = max(正常最大连续子段和,总和-最小连续子段和)，再写一个最小连续子段和就AC了
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }
            System.out.println(Math.max(getMax(nums), sum - getMin(nums)));
        }
    }

    public static int getMax(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int getMin(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int min = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(dp[i-1], 0) + nums[i];
            min = Math.min(dp[i], min);
        }
        return min;
    }


    /**
     * 思路1：复制一倍的原数组组成新的数组，然后对新的数组寻找范围不超过原数组的最大连续和
     * 时间复杂度O(n^2) 空间复杂度O(n)
     */
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] nums = new int[n*2];
            int[] pre = new int[n*2];
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                nums[i] = num;
                nums[i+n]= num;
            }
            int sum= 0;

            for (int i = 0; i < 2 * n; i++) {
                sum += nums[i];
                pre[i]= sum;
            }

            int max = 0;
            for (int i = 0; i < n * 2; i++) {
                for (int j = i; j < n * 2; j++) {
                    if (j - i < n){
                        max = Math.max(max, pre[j] - pre[i] + nums[i]);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
