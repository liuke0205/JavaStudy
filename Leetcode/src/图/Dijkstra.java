package 图;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/4/16 0:48
 */
public class Dijkstra {

    List<Integer>[] graph;

    public int[] dijkstra(int start, List<Integer>[] graph){
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

            for (int nextNodeID: adj(curNodeID)) {
                int nextDistFromStart = curDistFromStart + weight(curNodeID, nextNodeID);
                if (distTo[nextNodeID] > nextDistFromStart){
                    distTo[nextNodeID] = nextDistFromStart;
                    heap.add(new State(nextNodeID, nextDistFromStart));
                }
            }
        }
        return distTo;
    }

    private int weight(int curNodeID, int nextNodeID) {
        return graph[curNodeID].get(nextNodeID);
    }

    public List<Integer> adj(int node){
        return graph[node];
    }
}

class State{
    int id;
    int distFromStart;
    public State(int id, int distFromStart){
        this.id = id;
        this.distFromStart = distFromStart;
    }
}