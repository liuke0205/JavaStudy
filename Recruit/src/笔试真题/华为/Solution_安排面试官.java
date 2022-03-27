package 笔试真题.华为;

import java.util.*;

public class Solution_安排面试官 {
    /**
     * 有M个面试官。每个面试官熟悉的编程语言是一个列表（可能熟悉多门语言）
     * 有N个面试者，每个面试者熟悉一门语言，每个面试官最多面试X个人，每个面试者必须被不同的面试官面试两次
     *
     * 请问能否给出一个匹配使得所有的面试者都能被面试官面试
     *
     * 输入：
     * 第一行是3个整数，M,N,X
     * 然后是M行
     * 然后是N行
     *
     * 输出：
     * 第一行是true或false，表示能否匹配
     * 如果能匹配，从第二行输出一个二维数组match
     * match[i][j] 代表第i个面试官是否面试第j个面试者
     */
    static boolean flag = false;
    static int[] monitor;
    static Map<String, List<Integer>> map;
    static String[] interviews;
    static int[][] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);

        monitor = new int[m];
        Arrays.fill(monitor, x);

        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] list = sc.nextLine().split(" ");
            for (String s: list) {
                if (!map.containsKey(s)){
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(i);
            }
        }

        interviews = new String[2 * n];
        for (int i = 0; i < n; i++) {
            interviews[i] = sc.next();
            interviews[i + n] = interviews[i];
        }

        res = new int[m][n];
        getResult(0, n);
        System.out.println(flag);
        if (flag){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void getResult(int index, int n){
        if (index == interviews.length){
            flag = true;
            return;
        }
        if (map.containsKey(interviews[index])){
            List<Integer> cur = map.get(interviews[index]);
            for (int i = 0; i < cur.size(); i++) {
                int mintorIdx = cur.get(i);
                if (monitor[mintorIdx] <=0 || res[mintorIdx][index % n] == 1){
                    continue;
                }
                monitor[mintorIdx]--;
                res[mintorIdx][index % n ] = 1;
                getResult(index + 1, n);
                if (flag){
                    break;
                }
                res[mintorIdx][index % n] = 0;
                monitor[mintorIdx]++;
            }
        }
    }
}
/*
4 6 4
Java C++ Python
Python
C++ Java
Python
Java
Python
C++
Python
C++
Java
*/