package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/7 22:53
 */
public class Solution_429N叉树的层序遍历 {
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null){
//            return res;
//        }
//        Deque<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> temp = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.pollFirst();
//                temp.add(node.val);
//                for (Node ch : node.children) {
//                    if (ch != null){
//                        queue.addLast(ch);
//                    }
//                }
//            }
//            res.add(new ArrayList<>(temp));
//        }
//        return res;
//    }
}
