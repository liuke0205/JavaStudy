package 图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuke
 * @date 2022/4/12 0:56
 */
public class Solution207_课程表 {
    /**
     * https://leetcode-cn.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.构造图的邻接矩阵 和 入度表
        int[][] graph = new int[numCourses][numCourses];
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            graph[from][to] = 1;
            in[to]++;
        }

        // 2.构造一个队列用来存储入度为0的点
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 3.队列初始化（将初始入度为0的入队）
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (graph[node][i] == 1){
                    in[i]--;
                    graph[node][i] = 0;
                    if (in[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
