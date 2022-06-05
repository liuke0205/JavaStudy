package 笔试真题.快手;

import java.util.Scanner;

public class Main_求x到y的最少计算次数 {
    /**
     * https://www.nowcoder.com/questionTerminal/45d04d4d047c48768543eeec95798ed6?f=discussion
     */
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(",");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        min = Math.abs(a - b);
        dfs(a, b, 0);
        System.out.println(min);
    }

    public static void dfs(int a, int b, int cnt){
        if (cnt == min){
            return;
        }
        if (a == b){
            min = cnt;
            return;
        }
        dfs(a+1, b, cnt+1);
        dfs(a-1, b, cnt+1);
        dfs(a*2, b, cnt+1);
    }
}
