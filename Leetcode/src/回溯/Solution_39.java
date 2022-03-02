package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:20
 */
public class Solution_39 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
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

            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
