package 笔试真题.美团;

import java.util.HashSet;
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
    static int max = 0;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        visited = new boolean[m + 1];
        backtracking(arr, 0, 0);
        System.out.println(max);
    }

    private static void backtracking(int[][] arr, int index, int count) {
        if (index == arr.length){
            max = Math.max(max, count);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!visited[arr[i][0]] && !visited[arr[i][1]]){
                visited[arr[i][0]] = true;
                visited[arr[i][1]] = true;
                backtracking(arr, i + 1, count++);
                visited[arr[i][0]] = false;
                visited[arr[i][1]] = false;
            }
        }
    }

}
