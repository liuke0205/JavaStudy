package 笔试真题.拼多多;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 迷宫寻路 {
    /**
     * https://www.nowcoder.com/questionTerminal/e3fc4f8094964a589735d640424b6a47
     *
     */
    // maze迷宫，isVisited表示状态是否有过，有过就是true start开始结点
    public static int BFS(char[][] maze, boolean[][][] isVisited, Node2 start) {
        Queue<Node2> queue = new LinkedList<>(); // bfs队列
        queue.add(start);
        isVisited[start.x][start.y][0] = true; // 用比特位来表示对应为门是否有要是
        // 'A'表示标号为0位的门是否有钥匙
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Node2 now, next; // now 表示当前结点，next表示要进入队列的结点
        int M = maze.length;
        int N = maze[0].length;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (maze[now.x][now.y] == '3') {  // 如果该点是终点 结束
                return now.deep;
            }
            for (int i = 0; i < 4; i++) {
                //当前如果是钥匙，next.keys在下面的步骤会改变
                next = new Node2(now.x + dirs[i][0], now.y + dirs[i][1], now.keys, now.deep + 1);

                if (next.x < 0 || next.x >= M || next.y < 0 || next.y >= N
                        || maze[next.x][next.y] == '0') { //不能走就不进入队列
                    continue;
                }
                if (maze[next.x][next.y] <= 'Z' && maze[next.x][next.y] >= 'A'
                        && (now.keys & (1 << (maze[next.x][next.y] - 'A'))) == 0) {
                    continue;   //next结点为门，now没有对应钥匙就不走（next 不进队列）
                }
                if (maze[next.x][next.y] <= 'z' && maze[next.x][next.y] >= 'a') {
                    //是钥匙 就将next.keys重新赋值
                    next.keys = next.keys | 1 << (maze[next.x][next.y] - 'a');
                }
                if (!isVisited[next.x][next.y][now.keys]) {
                    //next的状态没来过就标记
                    isVisited[next.x][next.y][now.keys] = true;
                    //next 进入队列
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            int M = Integer.valueOf(strings[0]);
            int N = Integer.valueOf(strings[1]);
            char[][] maze = new char[M][N];
            Node2 start = new Node2(0, 0, 0, 0);
            int gate = 0;
            for (int i = 0; i < M; i++) {
                maze[i] = sc.nextLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    //找起点
                    if (maze[i][j] == '2') {
                        start.x = i;
                        start.y = j;
                    }
                    //统计一共多少门
                    if (maze[i][j] <= 'Z' && maze[i][j] >= 'A') {
                        gate++;
                    }
                }
            }
            //所有状态的 访问情况
            boolean[][][] isVisited = new boolean[M][N][2 << gate];
            //只输出路径的步数（不包括起点）
            System.out.println(BFS(maze, isVisited, start));
        }
        sc.close();
    }
}

class Node2 {
    int x;
    int y;
    int keys;
    int deep;

    public Node2(int x, int y, int keys, int deep) {
        super();
        this.x = x;
        this.y = y;
        this.keys = keys;
        this.deep = deep;
    }
}
