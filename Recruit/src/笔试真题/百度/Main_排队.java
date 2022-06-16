package 笔试真题.百度;

import java.util.Map;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/15 22:02
 */
public class Main_排队 {

    // 存储所有节点的root
    public static int[] first = new int[100005];
    // 存储当前节点的root的最后一个孩子
    public static int[] last = new int[100005];
    // 存储当前节点到父节点的深度
    public static int[] weight = new int[100005];
    /**
     * https://www.nowcoder.com/questionTerminal/4e5a92f97823486ca2d7dd5bdd1fa687
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            first[i] = i;
            last[i] = i;
            weight[i] = 0;
        }
        scanner.nextLine();
        while (m-->0){
            String[] params = scanner.nextLine().split(" ");
            int a = Integer.parseInt(params[1]);
            int b = Integer.parseInt(params[2]);

            if (params[0].equals("C")){
                // 将a连到b的尾部
               first[a] = last[b];
               last[find(b)] = last[a];
               weight[a] = 1;
            }else {
                if (find(a) == find(b)){
                    System.out.println(Math.max(0, Math.abs(weight[a] - weight[b]) - 1));
                }else {
                    System.out.println(-1);
                }
            }
        }
    }

    public static int find(int x) {
        if (first[x] != x){
            int pa = first[x];
            first[x] = find(first[x]);
            weight[x] += weight[pa];
        }
        return first[x];
    }
}

