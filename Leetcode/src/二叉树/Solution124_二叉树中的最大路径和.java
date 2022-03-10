package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 12:40
 */
public class Solution124_二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // 返回单分支的最大值
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
