package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:27
 */
public class Solution53_最大子数组 {
    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum <= 0){
                sum = 0;
            }
        }
        return max;
    }
}
