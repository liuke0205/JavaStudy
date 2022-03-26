package 笔试真题.网易;

import java.util.*;

class Main {
    /**
     * 某个群岛有n的小岛，某个小岛id=n出现了疫情，现需要从小岛0往小岛n运输物资，
     * 有一批物资重量为[w1,w2,w3, ... wn]表示，现在有一个4辆车的车队，物资不能拆分，但可以一辆车运送多个物资
     * 一辆车的载重最大为10
     * 用一个二维数组表示各个岛屿之间的运送时间，-1表示没有道路；
     *
     * 输入：物资重量数组、岛屿间运输时间二维数组
     * 输出：最快用时
     *
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] productList = new int[]{5, 5,6,6,10,10,10};
        int[][] drivingTimes = new int[][]{{0,1,5}, {1,0,2}, {5,1,0}};
        System.out.println(solution.getMinimumTime(productList, drivingTimes));
    }
}

class Solution {
    /**
     * 获取最少用时
     * @param productList int整型一维数组 物资重量数组
     * @param drivingTimes int整型二维数组 各个岛屿之间的开车时间，不存在道路的为 -1
     * @return int整型
     */

    private int[][] drivingTimes;
    public int getMinimumTime (int[] productList, int[][] drivingTimes) {
        // write code here
        this.drivingTimes = drivingTimes;
        int[] distTo = dijkstra(0, drivingTimes);
        int shortDist = distTo[drivingTimes.length - 1];

        int carNum = 0, curWeight = 0;
        Arrays.sort(productList);
        for (int i = 0; i < productList.length;) {
            curWeight += productList[i];
            if (curWeight > 10){
                carNum++;
                curWeight = 0;
            }else {
                i++;
            }
        }
        if (curWeight > 0){
            carNum++;
        }
        int loop = (carNum % 4 == 0) ? carNum / 4 : carNum / 4 + 1;
        return shortDist * (loop * 2 - 1);
    }

    class State{
        int distFromStart;
        int id;
        public State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public int[] dijkstra(int start, int[][] graph){
        int v = graph.length;
        int[] distTo = new int[v];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()){
            State cur = pq.poll();
            int curID = cur.id;
            int curDistFromStart = cur.distFromStart;
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
        return distTo;
    }

    private int weight(int curID, int nextID){
        return drivingTimes[curID][nextID];
    }

    private int[] adj(int curID) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < drivingTimes[curID].length; i++) {
            if (drivingTimes[curID][i] != -1 && drivingTimes[curID][i] != 0){
                arr.add(i);
            }
        }
        int[] res = new int[arr.size()];
        int idx = 0;
        for (Integer num : arr) {
            res[idx++] = num;
        }
        return  res;
    }
}