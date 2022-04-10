package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:26
 */
public class Solution376_摆动序列 {
    /**
     * https://leetcode-cn.com/problems/wiggle-subsequence/
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        // 记录峰值个数，序列默认序列最右边有一个峰值
        int cnt = 1;
        int curDiff = 0, preDiff = 0;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i+1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                preDiff = curDiff;
                cnt++;
            }
        }
        return cnt;
    }
}
