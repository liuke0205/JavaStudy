package 动态规划;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/2/28 22:44
 */
public class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1; i<len; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
