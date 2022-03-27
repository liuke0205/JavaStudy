package 笔试真题.华为;

import java.util.*;

/**
 * @author liuke
 * @date 2022/3/25 10:59
 */
public class Main {
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

    // 每个语言会的面试官有哪些
    static Map<String, List<Integer>> interviewee = new HashMap<>();
    // 每个面试官剩余面试数量
    static int[] number;
    // 所有面试者面试的语言
    static String[] people;
    // 面试者的个数
    static int n;
    // 标志是否能够寻找一个完美的匹配
    static boolean flag;
    // 存储匹配结果
    static int[][] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);

        for (int i = 0; i < m; i++) {
            String[] list = sc.nextLine().split(" ");
            for (String s: list) {
                if (!interviewee.containsKey(s)){
                    interviewee.put(s, new ArrayList<>());
                }
                interviewee.get(s).add(i);
            }
        }

        number = new int[m];
        Arrays.fill(number, x);

        people = new String[n * 2];
        for (int i = 0; i < n; i++) {
            String mesg = sc.next();
            people[i] = mesg;
            people[i + n] = mesg;
        }
        res = new int[m][n];

        // 深搜
        dfs(0);

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


    public static void dfs(int idx){
        if (idx == people.length) {
            flag = true;
            return;
        }

        // 判断是否有面试官会当前面试者的语言
        if (interviewee.containsKey(people[idx])){
            // 遍历会这门语言的所有面试官
            for (Integer people : interviewee.get(people[idx])) {
                if (number[people] <= 0 || res[people][idx % n] == 1){
                    continue;
                }
                number[people]--;
                res[people][idx % n] = 1;
                dfs(idx + 1);
                res[people][idx] = 0;
                number[people % n]++;
            }
        }
    }
}
