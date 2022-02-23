/**
 * @author liuke
 * @date 2022/2/23 22:39
 */
public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0){
            return 0;
        }
        target = (sum + target) /2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
