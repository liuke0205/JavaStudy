package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/21 12:13
 */
public class Solution15_三数之和 {
    /**
     * 思路：
     * 1. 首先对数组进行排序
     * 2. 利用两数之和 双指针的原理，在外层增加一个指针去遍历数组，双指针的第一个指针是从外层指针的下一个指针开始
     * 3. 难点是去重，那么当找到符合条件的时候双指针收缩一下看看是否元素一样
     * 题解：
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while (j < k && nums[k-1] == nums[k]){
                        k--;
                    }
                    j++;
                    k--;
                }else if (sum < 0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }
}
