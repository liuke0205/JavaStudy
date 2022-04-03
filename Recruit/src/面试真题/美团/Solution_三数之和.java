package 面试真题.美团;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/2 20:04
 */
public class Solution_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }
}
