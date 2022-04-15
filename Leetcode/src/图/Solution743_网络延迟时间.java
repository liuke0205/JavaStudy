package 图;

import java.util.*;

/**
 * @author liuke
 * @date 2022/4/12 1:00
 */
public class Solution743_网络延迟时间 {

    List<int[]>[] graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造图
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new int[]{to, weight});
        }
        int[] distTo = dijkstra(k, graph);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < distTo.length; i++) {
            if(distTo[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, distTo[i]);
        }
        return max;
    }

    public int[] dijkstra(int start, List<int[]>[] graph){
        int[] distTo = new int[graph.length];
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        heap.add(new State(start, 0));
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        while (!heap.isEmpty()){
            State curNode = heap.poll();
            int curNodeID = curNode.id;
            int curDistFromStart = curNode.distFromStart;
            if (curDistFromStart > distTo[curNodeID]){
                continue;
            }

            for (int[] neighbor: graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    heap.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

    class State{
        int id;
        int distFromStart;
        public State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
}
