package 二叉树;

/**
 * @author liuke
 * @date 2022/3/10 18:51
 */
public class Solution108_有序数组转二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
