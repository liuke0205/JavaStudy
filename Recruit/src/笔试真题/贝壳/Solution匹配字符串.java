package 笔试真题.贝壳;

import java.util.Scanner;


public class Solution匹配字符串 {
    /**
     * 给定一个由小写字母组成的n * n的矩形和一个字符串。问能匹配多少次指定的字符串
     * 匹配指的是：一个字符串从左往右 或者 从上往下 出现在矩形中
     */
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        String str = sc.next();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (str.charAt(0) == arr[i][j]){
                    dfs_down(arr, i, j, str, 0);
                    dfs_right(arr, i, j, str, 0);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs_right(char[][] arr, int i, int j, String str, int idx) {
        if (j >= arr[0].length || idx >= str.length() || str.charAt(idx) != arr[i][j]){
            return;
        }
        if (idx == str.length() - 1){
            res++;
            return;
        }
        dfs_right(arr, i, j+1, str, idx + 1);
    }

    private static void dfs_down(char[][] arr, int i, int j, String str, int idx) {
        if (i >= arr.length || idx >= str.length() || str.charAt(idx) != arr[i][j]){
            return;
        }
        if (idx == str.length() - 1){
            res++;
            return;
        }
        dfs_down(arr, i+1, j, str, idx + 1);
    }
    /**
     * 5
     * abc
     * abcaa
     * bcabc
     * cbacb
     * cabca
     * bbabc
     *
     * 6
     */
}
