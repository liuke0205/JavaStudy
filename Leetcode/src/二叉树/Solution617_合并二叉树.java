package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 0:22
 */
public class Solution617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
