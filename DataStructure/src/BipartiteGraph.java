/**
 * @author liuke
 * @date 2022/2/26 11:29
 * 二分图
 */

public class BipartiteGraph {
    // https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492491&idx=1&sn=4c6f4f6864640ecaa4e48acd0acd31c6&scene=21#wechat_redirect

    public void traverse(int[][] graph, boolean[] visited, int v){
        visited[v] = true;
        for (int neighbor : graph[v]) {
            if (!visited[neighbor]){
                // 如果相邻节点 neighbor 没有被访问过
                // 那么应该给节点 neighbor 涂上和节点 v 不同的颜色
                traverse(graph, visited, neighbor);
            }else {
                // 相邻节点 neighbor 已经被访问过
                // 那么应该比较节点 neighbor 和节点 v 的颜色
                // 若相同，则此图不是二分图
            }
        }
    }

}
