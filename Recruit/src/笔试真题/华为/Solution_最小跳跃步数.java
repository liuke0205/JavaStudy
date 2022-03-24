package 笔试真题.华为;

import java.util.Scanner;

public class Solution_最小跳跃步数 {
    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        k = sc.nextInt();
        int max = 0;
        int end = 0, step = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] + i);
            if (i == end){
                end = max;
                step++;
            }
        }
        if (step <= k){
            System.out.println(step);
        }else {
            System.out.println(-1);
        }
    }
}
