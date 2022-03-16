package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/15 18:16
 */
public class Solution_点菜 {
    /**
     * 食材只够每种菜做一份，现在不同时刻（不分先后顺序）来了n个顾客。
     * 每个顾客都有想两份要点的菜的时候，顾客才会满意
     * 现在的任务：合理地接取顾客的订单要求，尽可能让更多的顾客满意
     * 输出最多有多少个顾客满意
     *
     * 测试用例：
     * 3 4（3代表顾客的个数，4代表[1,4]菜的编号）
     * 1 2（每一名顾客所点的两道菜的编号）
     * 2 3
     * 3 4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(fun(arr));
    }

    private static boolean fun(int[][] arr) {
        return false;
    }
}
