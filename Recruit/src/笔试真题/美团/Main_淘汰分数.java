package 笔试真题.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main_淘汰分数 {
    /**
     * https://www.nowcoder.com/questionTerminal/9c4a4e879b4f49939dfaebea8948f976
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int i = 0;
        while (i++ < n){
            int c1 = i + 1, c2 = n - i - 1;
            if (c1 >= x && c1 <= y && c2 >= x && c2 <= y){
                System.out.println(nums[i]);
                break;
            }
        }
        if (i == n){
            System.out.println(-1);
        }
    }
}
