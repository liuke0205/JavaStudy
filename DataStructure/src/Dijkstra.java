import java.util.*;

/**
 * @author liuke
 * @date 2022/2/26 11:30
 */
public class Dijkstra {
    // 743 网络延迟时间
    // https://leetcode-cn.com/problems/network-delay-time/
    public int networkDelayTime(int[][] times, int n, int k) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        LinkedList[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造图
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].add(new int[]{to, weight});
        }
        //调用迪杰斯特拉算法，求以节点k出发到每个节点的最短路径
        int[] res = dijkstra(k, graph);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<res.length; i++){
            System.out.print(res[i] + " ");
            if(res[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public int[] dijkstra(int start, LinkedList<int[]>[] graph){
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<State>(Comparator.comparingInt(a -> a.distFromStart));
        pq.add(new State(start, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curNodeID = cur.id;
            int curDistFromState = cur.distFromStart;
            if(curDistFromState > distTo[curNodeID]){
                continue;
            }
            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
class State{
    int id;//图节点id
    int distFromStart;//从开始节点到当前节点的距离
    public State(int id, int distFromStart){
        this.id = id;
        this.distFromStart = distFromStart;
    }
}