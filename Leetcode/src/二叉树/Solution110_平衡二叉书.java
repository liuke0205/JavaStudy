package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 23:26
 */
public class Solution110_平衡二叉书 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
