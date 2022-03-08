package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 22:59
 */
public class Solution222_完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 求左右子树的深度
        int leftDepth = 0, rightDepth = 0;
        TreeNode left = root.left, right = root.right;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
