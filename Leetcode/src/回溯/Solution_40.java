package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:20
 */
public class Solution_40 {
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }
    public void backtracking(int[] candidates,int target, int sum, int idx){
        if (sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1);
            sum -= candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
