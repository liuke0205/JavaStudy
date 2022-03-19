package 笔试真题.美团;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/19 10:59
 */
public class Solution_整除 {
    /**
     * 有一个随子里装了几个球，球被编号为1到n,且每个球上都写了一个根数。
     * 现在小团想选出一些球。使得这些球满足以下条件:
     * 1.球上所写的数之和可以被k整除
     * 2.球上所写的数之和不能被k2整除
     * 3.在满足前两个条件的前提下，球上所写的数之和要尽可能的大
     * 小团还想知道在满足这些条件的情况下有多少种不同的选择方法。
     * 两种选择方法相同当且仅当它们选择的球的编号完全相同，
     */
    static int max_val = Integer.MIN_VALUE;
    static int cnt = 0;
    static final int MOD = 998244353;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        dfs(arr, k1, k2, 0, 0);
        System.out.println(max_val + " " + cnt % MOD);
    }

    private static void dfs(int[] arr, int k1, int k2, int idx, int sum) {
        if (sum % k1 == 0 && sum % k2 != 0){
            if (sum > max_val){
                cnt = 1;
                max_val = sum;
            }else if (sum == max_val){
                cnt++;
            }
        }
        if (idx == arr.length){
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sum += arr[i];
            dfs(arr, k1, k2, i + 1, sum);
            sum -= arr[i];
        }
    }
}
