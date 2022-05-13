package 前缀和;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/5/13 23:57
 */
public class Solution560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            // res的值则需要查找map中是否已存在pre[i] - k的元素
            // 也就是在查找此前所有从0项开始累加的连续子项和中有没有pre[i] - k
            int num = pre[i] - k;
            if (map.containsKey(num)){
                cnt += map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
