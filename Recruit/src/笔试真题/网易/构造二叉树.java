package 笔试真题.网易;

import java.util.Scanner;

public class 构造二叉树 {
    /**
     *
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
