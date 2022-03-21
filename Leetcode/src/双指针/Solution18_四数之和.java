package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/21 12:13
 */
public class Solution18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > 0 && nums[j] == nums[j-1]){
                    continue;
                }
                int m = j + 1, k = nums.length - 1;
                while (m < k){
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        while (m < k && nums[m] == nums[m + 1]){
                            m++;
                        }
                        while (m < k && nums[k] == nums[k - 1]){
                            k--;
                        }
                        m++;
                        k--;
                    }else if(sum < 0){
                        m++;
                    }else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
