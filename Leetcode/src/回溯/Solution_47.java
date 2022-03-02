package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:20
 */
public class Solution_47 {
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }
    public void backtracking(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            // 同一树枝去重
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
