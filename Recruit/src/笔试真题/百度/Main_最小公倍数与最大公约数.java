package 笔试真题.百度;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/11 0:25
 */
public class Main_最小公倍数与最大公约数 {
    /**
     *
     * 思路：求最小公倍数 - 最大公约数 的 最大数
     *
     * 相邻的自然数（大于1）的最大公因数是1，最小公倍数是两者之积
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(n * (n-1) - 1);
    }
}
