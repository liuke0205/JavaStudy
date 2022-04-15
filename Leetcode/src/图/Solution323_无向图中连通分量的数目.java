package 图;

/**
 * @author liuke
 * @date 2022/4/12 0:56
 */
public class Solution323_无向图中连通分量的数目 {
    int countComponents(int n, int[][] edges){
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.count;
    }
}
