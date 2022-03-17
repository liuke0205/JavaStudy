package 笔试真题.美团;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/15 18:24
 */
public class Solution_避开炸弹 {
    /**
     * 有n个房间，小美最初在1号房间，游戏会持续m秒，每秒会有一个房间产生炸弹，小美的指针不能在这个房间中
     * 每秒结束的瞬间，小美可以使用一次魔法，将指针切换到另一个房间中（该过程会小豪1个能量）
     * 任务：计算小美无伤通过游戏所消耗的最少能量
     * 保证：最初炸弹不在1号房间
     *
     * 测试用例：
     * 2 4（2代表房间数，4代表游戏会持续多少秒）
     * 2 1 1 2（每秒炸弹在哪个房间爆炸）
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            if (set.size() == n){
                res++;
                set.clear();
            }
        }
        System.out.println(res);
    }
}
