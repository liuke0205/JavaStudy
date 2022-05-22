package 笔试真题.拼多多;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 16:24
 */
public class 最大乘积 {
    /**
     * https://www.nowcoder.com/questionTerminal/5f29c72b1ae14d92b9c3fa03a037ac5f
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);
        // 贪心策略： 3个最大的正数、1个最大的正数 + 2个最小的负数
        int i = 0, j = num.length - 1;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        while (i <= j){
            if (num[i] < 0){
                negative.add(num[i++]);
            }

            if (num[j] >= 0){
                positive.add(num[j--]);
            }
        }
        long max = Long.MIN_VALUE;
        if (positive.size() >= 3){
            max = Math.max(max, (long) positive.get(0) * positive.get(1) * positive.get(2));
            if (negative.size() >= 2){
                max = Math.max(max, (long) positive.get(0) * negative.get(0)*negative.get(1));
            }
        }else {
            max = Math.max(max, (long) positive.get(0) * negative.get(0)*negative.get(1));
        }
        System.out.println(max);
    }
}
