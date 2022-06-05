package 笔试真题.快手;

import java.util.Scanner;

public class Main_二进制中有多少个1 {
    /**
     * https://www.nowcoder.com/questionTerminal/43d22dbc8bef46529e722dc6a5fb1e2d
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        while (n > 0){
            cnt += n & 1;
            n >>= 1;
        }
        System.out.println(cnt);
    }
}
