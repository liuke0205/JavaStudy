package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 22:06
 */
public class Solution104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
