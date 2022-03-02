package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:12
 */
public class Solution_216 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(n, k, 0, 1);
        return res;
    }
    public void backtracking(int n, int k, int sum, int idx){
        if(path.size() == k && sum == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i<=9; i++){
            path.add(i);
            sum += i;
            backtracking(n, k, sum, i+1);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
