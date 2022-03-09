package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 0:08
 */
public class Solution106_中序和后续构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int in_start, int in_end, int[] postorder, int po_start, int po_end) {
        if (in_start > in_end || po_start > po_end){
            return null;
        }
        int root_val = postorder[po_end];
        TreeNode root = new TreeNode(root_val);
        int idx = in_start;
        while (idx < in_end){
            if (inorder[idx] == root_val){
                break;
            }
            idx++;
        }
        int leftNum = idx - in_start;
        root.left = build(inorder, in_start, idx - 1, postorder, po_start, po_start + leftNum-1);
        root.right = build(inorder, idx + 1, in_end, postorder, po_start + leftNum, po_end-1);
        return root;
    }
}
