package 笔试真题.拼多多;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/18 23:21
 */
public class 多多的求和计算 {
    /**
     * 题目：
     * 多多路上从左到右有N棵树（编号1～N），其中第i个颗树有和谐值Ai。
     * 多多鸡认为，如果一段连续的树，它们的和谐值之和可以被M整除，那么这个区间整体看起来就是和谐的。
     * 现在多多鸡想请你帮忙计算一下，满足和谐条件的区间的数量。
     *
     * 思路：
     * 用map统计每个位置前缀和余数的个数，相同余数的区间必然能被m整除
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
            int mod = sum % m;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        // 相同余数任选2个都可以和谐区间
        int res = 0;
        for (Integer key: map.keySet()) {
            int val = map.get(key);
            res += (val - 1) * val / 2;
        }
        System.out.println(res);
    }
}
