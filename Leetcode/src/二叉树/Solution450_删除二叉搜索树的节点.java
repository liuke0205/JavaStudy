package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 18:18
 */
public class Solution450_删除二叉搜索树的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }else {
            //1.当前节点为叶子节点
            if (root.left == null && root.right == null){
                return null;
            }else if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {//左右节点都不为空
                //1.找到右子树的最左边节点
                TreeNode cur = root.right;
                while (cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
