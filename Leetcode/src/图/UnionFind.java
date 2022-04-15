package 图;

/**
 * @author liuke
 * @date 2022/4/16 0:36
 */

class UnionFind{
    public int count;
    private int[] parent;
    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    // 将节点p和q连通
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootQ == rootP){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    // 判断两个节点是否已经连通
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootQ == rootP;
    }

    // 寻找节点的父节点
    private int find(int x){
        while (parent[x] != x){
            x = parent[x];
        }
        return x;
    }
}
