package 图;

/**
 * @author liuke
 * @date 2022/4/12 0:58
 */
public class Solution261_以图判树 {
    boolean validTree(int n, int[][] edges){
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if (uf.connected(a,b)){
                return false;
            }else {
                uf.union(a, b);
            }
        }
        return uf.count == 1;
    }
}
