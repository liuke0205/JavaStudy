package 二叉树;

/**
 * @author liuke
 * @date 2022/3/8 22:14
 */
public class Solution226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
