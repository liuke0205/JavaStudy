package 哈希表;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/3/27 23:33
 */
public class Solution1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
