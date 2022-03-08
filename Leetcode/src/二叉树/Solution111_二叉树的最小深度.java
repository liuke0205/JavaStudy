package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 22:10
 */
public class Solution111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null){
            return minDepth(root.right) + 1;
        }else if (root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
