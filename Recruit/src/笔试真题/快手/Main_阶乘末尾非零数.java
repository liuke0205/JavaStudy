package 笔试真题.快手;

import java.util.Scanner;

public class Main_阶乘末尾非零数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            while (res % 10 == 0){
                // 每次乘完后都把末尾的0给去掉
                res /= 10;
            }
            // 根据测试用例 仅保留后面几位即可！
            res = res % 1000000;
        }
        System.out.println(res % 10);
    }
}
