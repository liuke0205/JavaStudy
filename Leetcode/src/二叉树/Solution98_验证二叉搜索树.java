package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 15:21
 */
public class Solution98_验证二叉搜索树 {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null){
            if (root.val <= pre.val){
                return false;
            }
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
