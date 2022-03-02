package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 22:19
 */
public class Solution_78 {

    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int idx){
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
