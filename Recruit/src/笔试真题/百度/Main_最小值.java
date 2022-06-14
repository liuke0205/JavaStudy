package 笔试真题.百度;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/12 13:33
 */
public class Main_最小值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();
        long min = Math.min(n, m);
        long max = Math.max(n, m);
        System.out.println(min - k / max);
    }
}
