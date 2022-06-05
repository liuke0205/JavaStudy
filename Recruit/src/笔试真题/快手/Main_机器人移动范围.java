package 笔试真题.快手;

import java.util.Scanner;

public class Main_机器人移动范围 {
    /**
     * https://www.nowcoder.com/questionTerminal/8314cb12d35b4e2a920b3bd0474fe1f2
     */
    static int m, n, k;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();
        visited = new boolean[m][n];
        System.out.println(dfs(0, 0));
    }
    public static int dfs(int x, int y){
        if (x < 0 || x >= m || y < 0 || y >= n || (getNum(x) + getNum(y) > k) || visited[x][y]){
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x +1, y) + dfs(x-1, y) + dfs(x, y-1)+dfs(x, y+1);
    }

    public static int getNum(int x) {
        int sum = 0;
        while (x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
