package 笔试真题.华为;

import java.util.Scanner;

public class Solution_最小跳跃步数 {
    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     * <p>
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     *
     * 输入：
     * 5
     * 2 3 1 1 4
     * 2
     *
     * 输出：
     * 2
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int k;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        k = sc.nextInt();

        int curDistance = 0;    // 当前覆盖的最远距离下标
        int step = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖的最远距离下标
        for (int i = 0; i < nums.length - 1; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);
            //遍历到了当前覆盖的最远距离下标，那就更新边界值
            if (curDistance == i) {
                step++;
                curDistance = nextDistance;
            }
        }
        if (step <= k) {
            System.out.println(step);
        } else {
            System.out.println(-1);
        }
    }
}
