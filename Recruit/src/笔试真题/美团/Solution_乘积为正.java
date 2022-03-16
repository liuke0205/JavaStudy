package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/15 18:07
 */
public class Solution_乘积为正 {
    /**
     * 有一个序列仅包含1和-1两种数字，要求有多少个连续的子序列，序列中的数字乘积为正
     * 测试用例：
     * 4
     * 1 1 -1 -1
     *
     * 6
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(fun(arr));
    }
    public static int fun(int[] arr){
        int res = 0;
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = (arr[i] == 1) ? 1 : -1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                dp[i][j] = dp[i][j-1] * arr[j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (dp[i][j] == 1){
                    res++;
                }
            }
        }

        return res;
    }
}
