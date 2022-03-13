import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuke
 * @date 2022/2/26 0:12
 */
public class Topology {
    // 力扣207 课程表 https://leetcode-cn.com/problems/course-schedule/
    // 使用拓扑排序检测是否存在循环依赖

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indeg = new int[numCourses];
        // 构造邻接矩阵
        for (int[] prerequisite : prerequisites) {
            int form = prerequisite[0];
            int to = prerequisite[1];
            graph[form][to] = 1;
            indeg[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 将入读为0的节点入队列
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0){
                queue.add(i);
            }
        }
        int num = 0; //记录没有环的个数
        while (!queue.isEmpty()){
            Integer from = queue.poll();
            num ++;
            //删除相关的边，如果遇到入读为0，直接入队
            for (Integer to: graph[from]) {
                graph[from][to] = 0;
                indeg[to]--;
                if (indeg[to] == 0){
                    queue.add(to);
                }
            }
        }
        return num == numCourses;
    }
}
