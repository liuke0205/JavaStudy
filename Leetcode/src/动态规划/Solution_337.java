package 动态规划;


/**
 * @author liuke
 * @date 2022/3/5 0:04
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_337 {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    // 树形DP：dp[0]返回当前节点不抢的最大值；dp[1]返回当前节点抢的最大值
    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int rob = root.val + left[0] + right[0];
        int no_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, no_rob};
    }
}
