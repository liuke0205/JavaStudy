package th12;

import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main5 {
	public static void main(String[] args) {
        System.out.println(dijkstra(1, 2021));
	}

	
	public static int dijkstra(int start, int end){
        int[] distTo = new int[2022];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()){
            State cur = pq.poll();
            int curID = cur.id;
            int curDistFromStart = cur.distFromStart;
            
            if (curID == end) {
				return curDistFromStart;
			}
            // 如果当前的距离已经比存储的还大，那么这个节点就不用比较了
            if (curDistFromStart > distTo[curID]){
            	continue;
            }

            // 遍历当前节点的相邻节点
            for (int nextID : adj(curID)) {
                int distToNext = distTo[curID] + weight(curID, nextID);
                if (distTo[nextID] > distToNext){
                    distTo[nextID] = distToNext;
                    pq.offer(new State(nextID, distToNext));
                }
            }
        }
        return 0;
    }

    private static int weight(int curID, int nextID){
    	return fun(curID, nextID);
    }
    
    private static int fun(int a, int b) {
    	int i = Math.max(a, b);
    	while (i <= a * b) {
    		if (i % a == 0 && i % b == 0) {
				break;
			}
		}
		return i;
	}

    private static List<Integer> adj(int curID) {
    	List<Integer> res = new ArrayList<>();
    	for (int i = curID - 21; i <= curID + 21; i++) {
			if (i >= 1) {
				res.add(i);
			}
		}
        return res;
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
