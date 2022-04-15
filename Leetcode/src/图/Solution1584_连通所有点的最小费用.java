package 图;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/12 0:58
 */
public class Solution1584_连通所有点的最小费用 {
    public int minCostConnectPoints(int[][] points) {
        // 生成所有边之间的距离
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // 用坐标点在 points 中的索引表示坐标点
                edges.add(new int[]{i, j, Math.abs(x1-x2) + Math.abs(y1-y2)});
            }
        }
        Collections.sort(edges, (a, b)->{
            return a[2] - b[2];
        });

        int mst = 0;
        UnionFind uf = new UnionFind(points.length);
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wight = edge[2];
            if (uf.connected(u, v)){
                continue;
            }else {
                uf.union(u, v);
                mst += wight;
            }
        }
        return mst;
    }
}
