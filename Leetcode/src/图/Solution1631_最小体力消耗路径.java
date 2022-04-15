package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/4/12 1:00
 */
public class Solution1631_最小体力消耗路径 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] distTo = new int[m][n];
        PriorityQueue<Loc> heap = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        heap.add(new Loc(0,0, 0));
        for (int i = 0; i < m; i++) {
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }

        distTo[0][0] = 0;

        while (!heap.isEmpty()){
            Loc curNode = heap.poll();
            int curNodeX = curNode.x;
            int curNodeY = curNode.y;
            int curDistFromStart = curNode.distFromStart;
            // 到达终点提前结束
            if (curNodeX == m - 1 && curNodeY == n - 1) {
                return curDistFromStart;
            }
            if (curDistFromStart > distTo[curNodeX][curNodeY]){
                continue;
            }

            // 将 (curX, curY) 的相邻坐标装入队列
            for (int[] neighbor : adj(heights, curNodeX, curNodeY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
                int effortToNextNode = Math.max(
                        distTo[curNodeX][curNodeY],
                        Math.abs(heights[curNodeX][curNodeY] - heights[nextX][nextY])
                );
                // 更新 dp table
                if (distTo[nextX][nextY] > effortToNextNode) {
                    distTo[nextX][nextY] = effortToNextNode;
                    heap.offer(new Loc(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }

    private List<int[]> adj(int[][] matrix, int x, int y) {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = matrix.length, n = matrix[0].length;
        // 存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                // 索引越界
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    class Loc{
        int x, y;
        int distFromStart;
        public Loc(int x, int y, int distFromStart){
            this.x = x;
            this.y = y;
            this.distFromStart = distFromStart;
        }
    }

}
