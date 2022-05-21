package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/20 0:41
 */
public class 多多的魔术盒子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            int n = scanner.nextInt();
            System.out.println((int)(Math.floor(Math.log(n) / Math.log(2)) + 1));
        }
    }
}
