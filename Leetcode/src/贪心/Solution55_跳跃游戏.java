package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:28
 */
public class Solution55_跳跃游戏 {
    /**
     * https://leetcode-cn.com/problems/jump-game/
     */
    public boolean canJump(int[] nums) {
        int curMax = 0;
        for (int i = 0; i <= curMax; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (curMax >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
