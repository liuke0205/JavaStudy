package 笔试真题.网易;

import java.util.Scanner;

public class 最小攻击次数 {
    /**
     *  a 和 b 是两个人的血量
     *  x 是对单个的攻击力
     *  y 是对两个一起攻击的攻击力
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = fun(a, b, x, y);
        System.out.println(res);
    }
    public static int fun(int a, int b, int x, int y){
        int max = Math.max(x, y);
        if (x >= 2 * y){
            return getResult(a, max) + getResult(b, max);
        }else{
            return getResult(Math.max(a, b), y);
        }
    }

    public static int getResult(int a, int b){
        return a/ b + (a % b != 0 ? 1 : 0);
    }
}
