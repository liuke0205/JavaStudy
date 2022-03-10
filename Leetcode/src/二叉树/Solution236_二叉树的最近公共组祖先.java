package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 17:54
 */
public class Solution236_二叉树的最近公共组祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        // 后序遍历
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if (right != null){
            return right;
        }
        return null;
    }
}
