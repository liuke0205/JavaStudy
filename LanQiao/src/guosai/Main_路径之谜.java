package guosai;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_路径之谜 {

    static int dx[];
    static int dy[];
    static int map[][];
    static int n;
    static int temp_x[] = {1, 0, -1, 0};
    static int temp_y[] = {0, 1, 0, -1};
    static LinkedList<Integer> lis = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dy = new int[n];
        dx = new int[n];
        map = new int[n][n];
        for (int i = 0; i < dx.length; i++) {
            dx[i] = scan.nextInt();
        }
        for (int i = 0; i < dy.length; i++) {
            dy[i] = scan.nextInt();
        }

        dx[0]--;
        dy[0]--;
        map[0][0] = 1;
        lis.add(0);
        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (x == n - 1 && y == n - 1 && check()) {
            for (int i = 0; i < lis.size(); i++) {
                System.out.print(lis.get(i) + " ");
            }
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            int tempX = x + temp_x[i];
            int tempY = y + temp_y[i];

            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
                if (map[tempX][tempY] == 0 && dx[tempX] > 0 && dy[tempY] > 0) {
                    dx[tempX]--;
                    dy[tempY]--;
                    map[tempX][tempY] = 1;
                    lis.add(path(tempX, tempY));
                    dfs(tempX, tempY);
                    dx[tempX]++;
                    dy[tempY]++;
                    map[tempX][tempY] = 0;
                    lis.remove(lis.size() - 1);
                }
            }
        }
    }
    static boolean check(){
        for (int i = 0; i < n; i++) {
            if (dy[i] != 0 || dx[i] != 0)
                return false;
        }
        return true;
    }
    static int path(int x, int y) {
        return y * n + x;
    }

}