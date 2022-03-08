package 二叉树;

import java.util.*;

/**
 * @author liuke
 * @date 2022/3/7 22:25
 */
public class Solution_199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.pollFirst();
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }
}
