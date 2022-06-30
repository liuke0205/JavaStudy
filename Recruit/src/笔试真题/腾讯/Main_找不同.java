package 笔试真题.腾讯;

import java.util.Scanner;

public class Main_找不同 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] nums = new int[1001];
            for (int i = 0; i < n; i++) {
                nums[scanner.nextInt()] ++;
            }
            int idx = 0;
            while (idx < 1001){
                if (nums[idx] == 1){
                    System.out.println(idx);
                    break;
                }
                idx++;
            }
            if (idx == 1001){
                System.out.println(-1);
            }
        }
    }
}
