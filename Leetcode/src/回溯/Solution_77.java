package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:12
 */
public class Solution_77 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(n, k, 1);
        return res;
    }
    public void backtracking(int n, int k, int idx){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i<=n; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
