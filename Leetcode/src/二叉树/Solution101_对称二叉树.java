package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 22:19
 */
public class Solution101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
