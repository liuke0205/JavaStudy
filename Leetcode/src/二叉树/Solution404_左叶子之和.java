package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 23:51
 */
public class Solution404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum = root.left.val;
            }
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
