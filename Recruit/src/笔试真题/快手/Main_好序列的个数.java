package 笔试真题.快手;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 1:34
 */
public class Main_好序列的个数 {
    /**
     * https://www.nowcoder.com/questionTerminal/f6d9b2475f904b9abd6c1faa2d2f8703
     *
     * @param args
     */
    static boolean[] visited;
    public static void main(String[] args) {
        long MOD = 10^9 + 7;

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < n - 1; i++) {
            String[] strings = scanner.nextLine().split(" ");
            int u = Integer.parseInt(strings[0]);
            int v = Integer.parseInt(strings[1]);
            int color = Integer.parseInt(strings[2]);
            if (color == 0){
                graph[u][v] = 1;
                graph[v][u] = 1;
            }
        }

        visited = new boolean[n+1];

        long sum = 0;

        for (int i = 1; i < n+1; i++) {
            if (!visited[i]){
                sum = (sum + fastPow(dfs(graph, i), k)) % MOD;
            }
        }
        System.out.println((fastPow(n, k) - sum + MOD) % MOD);
    }

    public static int dfs(int[][] graph, int i){
        visited[i] = true;
        int cnt = 1;
        for (int j = 1; j < graph.length; j++) {
            if (graph[i][j] == 1 && !visited[j]){
                cnt += dfs(graph, j);
            }
        }
        return cnt;
    }

    public static long fastPow(int a, int b) {
        long res = 1;
        while(b != 0) {
            if(b%2 == 1)
                res = res * a;
            a = a * a ;
            b /= 2;
        }
        return res;
    }
}
