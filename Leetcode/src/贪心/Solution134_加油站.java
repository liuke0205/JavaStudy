package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:31
 */
public class Solution134_加油站 {
    /**
     * https://leetcode-cn.com/problems/gas-station/
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0){
            return -1;
        }
        int cur = 0, idx = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0){
                idx = i + 1;
                cur = 0;
            }
        }
        return idx;
    }
}
