package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 18:35
 */
public class Solution669_修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        if (root.val < low){
            // 寻找符合区间[low, high]的节点
            return trimBST(root.right, low, high);
        }
        if (root.val > high){
            // 寻找符合区间[low, high]的节点
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
