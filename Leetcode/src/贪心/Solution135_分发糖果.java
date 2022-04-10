package 贪心;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/7 0:31
 */
public class Solution135_分发糖果 {
    /**
     * https://leetcode-cn.com/problems/candy/
     */
    public int candy(int[] ratings) {
        // 思路：分两次贪心，首先从左到右贪心，然后再从右到左贪心（同时和之前的结果进行比较）
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]){
                right[i-1] = right[i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
