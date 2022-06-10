package 笔试真题.百度;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/11 0:52
 */

public class Main_还原数列 {
    /**
     * https://www.nowcoder.com/questionTerminal/eb725ab1ded844b58458389d57c073ea
     *
     * 思路： 一次可以减多倍，别人都+1，自己可以减1【56个民族，55加分，一个不加分===一个民族减分】
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        long[] a = new long[b];
        for (int i = 0; i < b; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        long count = 0;
        while (a[b - 1] >= b) {
            count += a[b - 1] / b;//计算最大值可以减去多少个N
            for (int i = 0; i < b - 1; i++) {
                a[i] += a[b - 1] / b;//直接每个值添加最大值可以减去多少个N的次数
            }
            a[b - 1] = a[b - 1] % b;//最大值小于N后的值
            Arrays.sort(a);
        }
        System.out.println(count);
    }
}