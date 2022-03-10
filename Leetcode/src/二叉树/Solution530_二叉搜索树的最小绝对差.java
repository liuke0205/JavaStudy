package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 17:15
 */
public class Solution530_二叉搜索树的最小绝对差 {
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre != null){
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
