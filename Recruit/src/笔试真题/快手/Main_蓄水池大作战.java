package 笔试真题.快手;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main_蓄水池大作战 {
    /**
     * https://www.nowcoder.com/questionTerminal/ce77ba1ab9aa4b18b31158972705cf75
     */
    static HashMap<Integer, ArrayList<Integer>> father = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> son = new HashMap<>();
    static int[] full;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        full = new int[n+1];
        while (--n > 0){
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            // 保证a1是最小的，a1是父节点
            if (a1 > a2){
                int temp = a1;
                a1 = a2;
                a2 = temp;
            }
            ArrayList<Integer> list1 = father.getOrDefault(a1, new ArrayList<>());
            list1.add(a2);
            father.put(a1, list1);

            ArrayList<Integer> list2 = son.getOrDefault(a2, new ArrayList<>());
            list2.add(a1);
            son.put(a2, list2);
        }
        int t = scanner.nextInt();
        while (t-- > 0){
            int c = scanner.nextInt();
            int num = scanner.nextInt();
            switch (c){
                case 1:
                    dfs(father, num, 1);
                    break;
                case 2:
                    dfs(son, num, 0);
                    break;
                case 3:
                    System.out.println(full[num]);
            }
        }
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> map, int k, int m){
        full[k]= m;
        for (Integer node : map.getOrDefault(k, new ArrayList<>())){
            full[node] = m;
            dfs(map, node, m);
        }
    }
}
