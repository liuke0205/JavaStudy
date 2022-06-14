package 笔试真题.百度;

import java.util.*;

/**
 * @author liuke
 * @date 2022/6/12 13:32
 */
public class Main_返回公司 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                List<Integer> list1 = map.getOrDefault(u, new ArrayList<>());
                list1.add(v);
                map.put(u, list1);
                List<Integer> list2 = map.getOrDefault(v, new ArrayList<>());
                list2.add(u);
                map.put(v, list2);
            }
            // BFS进行广度优先遍历，深度为2，看能否找到节点n
            if (DFS(n, map, 2, 1)){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean DFS(int n, Map<Integer, List<Integer>> map, int cnt, int cur){
        if (cur == n && cnt >= 0){
            return true;
        }else if (cur != n && cnt <= 0){
            return false;
        }
        if (map.containsKey(cur)){
            for (Integer next : map.getOrDefault(cur, new ArrayList<>())){
                if (next < cur){
                    continue;
                }
                if (DFS(n, map, cnt-1, next)){
                    return true;
                }
            }
        }
        return false;
    }
}
