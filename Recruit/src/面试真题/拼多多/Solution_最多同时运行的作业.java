package 面试真题.拼多多;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuke
 * @date 2022/4/1 15:26
 */
public class Solution_最多同时运行的作业 {
    /**
     * 有一个二维数组，nums[i][0] 代表作业i的开始时间，nums[i][1]代表作业的结束时间
     * 求哪个时刻同时运行的作业数最多？
     *
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,6}, {2,5}, {4,4}, {3,3}};
        int res = fun(arr);
        System.out.println(res);
    }

    public static int fun(int[][] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i][1]);
        }

        int[] nums = new int[max + 1];
        Difference diff = new Difference(nums);
        for (int i = 0; i < arr.length; i++) {
            diff.increment(arr[i][0], arr[i][1], 1);
        }

        int max_cnt = 0, time = -1;
        int[] result = diff.result();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max_cnt){
                time = i;
                max_cnt = result[i];
            }
        }

        return time;
    }
}


class Difference {
    // 差分数组
    private int[] diff;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i,j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}