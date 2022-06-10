package 笔试真题.美团;

import java.util.Scanner;

public class Main_式子求值 {
    /**
     * https://www.nowcoder.com/questionTerminal/e407f254e2c74c6dad7946cd54ef86a5
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        int[] multi = new int[n + 1];    // multi[i]表示0^1^2^...^i
        for(int i = 1; i <= n; i++) {
            res ^= scanner.nextInt();
            multi[i] = multi[i - 1]^i;
        }
        for(int i = 1; i <= n; i++){
            if((n/i) % 2 == 0)
                res ^= multi[n % i];
            else
                res ^= multi[n % i] ^ multi[i - 1];
        }
        System.out.println(res);
    }
}
