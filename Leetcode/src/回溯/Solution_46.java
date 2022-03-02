package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:20
 */
public class Solution_46 {
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        // 记录深度方向的数据
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
