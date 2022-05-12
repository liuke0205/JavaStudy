package 双指针;

/**
 * @author liuke
 * @date 2022/5/12 0:07
 */
public class Solution42_接雨水 {
    /**
     * 思路：
     * 1. 维护两个数组，分别记录当前值的左边和右边的最大值
     * 2. 当前能够盛的最多水 = min(left[i], right[i]) - height[i]
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        int sum = 0;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
            sum += (Math.min(right[i], left[i]) - height[i]);
        }
        return sum;
    }
}
