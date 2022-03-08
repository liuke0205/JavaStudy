package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 23:58
 */
public class Solution112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return backtracking(root, targetSum - root.val);
    }

    public boolean backtracking(TreeNode root, int targetSum){
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                return true;
            }
        }
        if (root.left != null){
            targetSum -= root.left.val;
            if (backtracking(root.left, targetSum)){
                return true;
            }
            targetSum += root.left.val;
        }
        if (root.right != null){
            targetSum -= root.right.val;
            if (backtracking(root.right, targetSum)){
                return true;
            }
            targetSum += root.right.val;
        }
        return false;
    }
}
