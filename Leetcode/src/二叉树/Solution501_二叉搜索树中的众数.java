package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/10 17:31
 */
public class Solution501_二叉搜索树中的众数 {
    List<Integer> res;
    int max, count;
    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    TreeNode pre;
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if(pre == null){
            count = 1;
        }else if(pre.val == root.val){
            count++;
        }else {
            count = 1;
        }
        if (count > max){
            max = count;
            res.clear();
            res.add(root.val);
        }else if (max == count){
            res.add(root.val);
        }
        pre = root;
        dfs(root.right);
    }
}
