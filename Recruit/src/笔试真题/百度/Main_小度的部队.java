package 笔试真题.百度;

import java.util.Scanner;

public class Main_小度的部队 {
    /**
     * https://www.nowcoder.com/questionTerminal/11b9d12df6b54c73aaccc7289d66f835
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(fun(n, k));
    }

    public static int fun(int n, int k){
        if (n <= k){
            return 1;
        }
        if ((n - k) % 2 != 0){
            return 1;
        }
        int x = (n - k) / 2;
        return fun(x, k) + fun(x + k, k);
    }
}
