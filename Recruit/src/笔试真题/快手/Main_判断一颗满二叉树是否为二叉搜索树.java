package 笔试真题.快手;

import java.util.Objects;
import java.util.Scanner;

public class Main_判断一颗满二叉树是否为二叉搜索树 {
    /**
     * https://www.nowcoder.com/questionTerminal/76fb9757332c467d933418f4adf5c73d
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (Objects.equals(str, "None")){
            System.out.println("True");
            return;
        }

        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        // 构造树
        Node root = buildTree(nums, 0);
        dfs(root);
        System.out.println(flag ? "False": "True");
    }

    static int pre = -1;
    static boolean flag = false;

    public static void dfs(Node root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre != -1 && root.val < pre){
            flag = true;
            return;
        }
        pre = root.val;
        dfs(root.right);
    }

    public static Node buildTree(int[] nums, int i){
        if (nums.length == 0 || i >= nums.length){
            return null;
        }
        Node root = new Node(nums[i]);
        if (i * 2 + 1 < nums.length){
            root.left = buildTree(nums, i*2+1);
        }
        if (i * 2 + 2 < nums.length){
            root.right = buildTree(nums, i*2+2);
        }
        return root;
    }

    static class Node{
        int val;
        Node left, right;
        public Node(int val){
            this.val = val;
        }
    }
}
