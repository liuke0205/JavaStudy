package 图;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/12 0:58
 */
public class Solution1135_最低成本联通所有城市 {
    int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b)->{
            return a[2] - b[2];
        });
        UnionFind uf = new UnionFind(n + 1);
        int mst = 0;
        for (int[] edge: connections) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];
            if (uf.connected(a, b)){
                continue;
            }else {
                mst += weight;
                uf.connected(a, b);
            }
        }
        return uf.count == 2 ? mst : -1;
    }
}