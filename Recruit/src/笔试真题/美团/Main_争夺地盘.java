package 笔试真题.美团;

import java.util.Scanner;

public class Main_争夺地盘 {
    /**
     * https://www.nowcoder.com/questionTerminal/84c09a2e657640f897127c81f09d6f02
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 0; i < p; i++) {
            nums[scanner.nextInt()]++;
        }
        for (int i = 0; i < q; i++) {
            nums[scanner.nextInt()]++;
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            if (nums[i] == 2){
                res++;
            }
        }
        System.out.printf("%d %d %d", p-res, q-res, res);
    }
}
