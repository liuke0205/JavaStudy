package 笔试真题.百度;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/22 23:40
 */
public class Solution_最长相同字符串 {

    /**
     *
     * 给出一个长度为n的01串，现在需要找出两个区间，使得两个区间中的0和1的个数相同
     * 两个区间可以相交，但是不能完全重叠。
     * 两个区间的长度是最长的。
     *
     * 输入：
     * 一行只有0 和 1的字符串，例如11011
     *
     * 输出：
     * 输出四个整数：s1, t1, s2, t2. 例如:1 4 2 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        int n = chars.length;
        int[][] prex = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i){
                    prex[i][j] = (chars[j] == '1' ? 1 : 0);
                    continue;
                }
                prex[i][j] = (chars[j] == '1' ? 1 : 0) + prex[i][j-1];
            }
        }

        for (int j = n-2; j >= 0 ; j++) {
            HashMap<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0, k = j ; k <= n-1 ; k++, i++) {
                if (map.containsKey(prex[i][k])){
                    Integer[] integers = map.get(prex[i][k]);
                    System.out.print((i + 1) + " " + (k + 1) + " " + integers[0] + " " + integers[1]);
                    break;
                }else {
                    map.put(prex[i][j], new Integer[]{i + 1, j + 1});
                }
            }
        }
    }
}
