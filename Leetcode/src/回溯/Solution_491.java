package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 22:19
 */
public class Solution_491 {

    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int idx){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        // 记录这个元素在本层用过了，本层后面不能再用了
        int[] used = new int[201];
        for (int i = idx; i < nums.length; i++) {
            if ((!path.isEmpty() && path.get(path.size() - 1) > nums[i])
                    || (used[nums[i] + 100] == 1)){
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
