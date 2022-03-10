package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 18:11
 */
public class Solution701_二叉搜索树种的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left, val);
        }else if (root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
