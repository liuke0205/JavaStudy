package 笔试真题.网易;

import java.util.Scanner;

public class 构造二叉树 {
    /**
     * 小红想构造一个总共n个节点完全二叉树，该二叉树满足以下两个性质：
     * 1. 所有节点的权值值为1 ~ n 的一个排列
     * 2、除了根节点外，每个节点的权值和它父亲的权值的乘积为偶数。
     *
     * 请你帮小红构造出这个二叉树，并按层序遍历的方式打印所有节点。
     *
     * 输入：一个整数n。代表二叉树的节点数量， 2 <= n <= 10^5
     * 输出：层序遍历的结果
     */

    static boolean[] visit;
    static int[] tree;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visit = new boolean[n + 1];
        tree = new int[n];
        dfs(0, n);
    }

    public static void dfs(int idx, int n) {
        if (flag) return;
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(tree[i] + " ");
            }
            System.out.println();
            flag = true;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (flag)break;
            if (visit[i]) continue;
            if ((idx == 0 && i % 2 == 0) || (idx > 0 && fun(i, tree[(idx - 1) / 2]))){
                visit[i] = true;
                tree[idx] = i;
                dfs(idx + 1, n);
                visit[i] = false;
            }
        }
    }
    public static boolean fun(int i, int val){
        return !visit[i] && (i * val % 2 == 0);
    }
}
