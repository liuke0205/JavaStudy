package 笔试真题.百度;

import java.util.*;

/**
 * @author liuke
 * @date 2022/6/11 1:23
 */
public class Main_树上升序列 {
    /**
     * https://www.nowcoder.com/questionTerminal/8eda05798f8c486a9f954432515ae436
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        weight = new int[n + 1];
        for (int i = 0; i < n; i++) {
            weight[i + 1] = scanner.nextInt();
        }
        // 构造无向图
        tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            List<Integer> uList = tree.getOrDefault(u, new ArrayList<>());
            uList.add(v);
            tree.put(u, uList);

            List<Integer> vList = tree.getOrDefault(v, new ArrayList<>());
            vList.add(u);
            tree.put(v, vList);
        }
        // 定义dp：从第i个定点出发的满足要求的最大长度，初始值为1（本身）
        dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            // 如果第i个节点的dp！=1，说明已经求解过了（最优子结构，避免重复计算）
            if (dp[i] != 1){
                continue;
            }
            // 递归求解
            dp[i] = dfs(i);
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int[] dp;
    static Map<Integer, List<Integer>> tree;
    static int[] weight;
    // 从s节点开始的最长路径
    private static int dfs(int s) {
        for(Integer next : tree.getOrDefault(s, new ArrayList<>())){
            if (weight[next] > weight[s]){
                dp[s] = Math.max(dp[s], dfs(next) + 1);
            }
        }
        return dp[s];
    }
}
