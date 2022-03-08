package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/8 21:55
 */

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution116_填充下一个右侧节点指针 {
    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        if (root == null){
            return root;
        }
        que.offerLast(root);
        while (!que.isEmpty()) {
            Node pre = null;
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                Node poll = que.pollFirst();
                if (pre != null){
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null) {
                    que.addLast(poll.left);
                }
                if (poll.right != null) {
                    que.addLast(poll.right);
                }
            }
        }
        return root;
    }
}
