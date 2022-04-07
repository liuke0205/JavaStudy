package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:29
 */
public class Solution45_跳跃游戏II {
    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     */
    public int jump(int[] nums) {
        int steps = 0;
        int cur = 0, next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);
            if (cur >= nums.length - 1){
                return steps;
            }
            if (cur == i){
                cur = next;
                steps++;
            }
        }
        return steps;
    }
}
