package 笔试真题.百度;

import java.util.*;

public class Main叶子删除计划 {
    /**
     * https://www.nowcoder.com/questionTerminal/427268b254234d1eabfbd9a6844ba896
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] edge = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            List<Integer> list1 = map.getOrDefault(u, new ArrayList<>());
            list1.add(v);
            map.put(u, list1);
            List<Integer> list2 = map.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            map.put(v, list2);
            edge[u]++;
            edge[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 将入度为1的节点放入队列
        for (int i = 1; i <= n; i++) {
            if (edge[i] == 1){
                queue.add(i);
            }
        }
        int[] res = new int[n + 1];
        int cnt = 0;
        while (!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                res[node] = cnt;
                List<Integer> list = map.getOrDefault(node, new ArrayList<>());
                map.remove(node);
                for (Integer next : list){
                    edge[next]--;
                    // 将next的list删除node
                    List<Integer> nextList = map.get(next);
                    nextList.remove(node);
                    map.put(next, nextList);
                    if (edge[next] == 1){
                        queue.add(next);
                    }
                }
            }
        }
        for (int i = 1; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
