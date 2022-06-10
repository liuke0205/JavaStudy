package 笔试真题.美团;

import java.util.Scanner;

public class Main_小团的装饰物2 {
    /**
     * https://www.nowcoder.com/questionTerminal/16fa5360a8eb4d879ae239e1f19c0d85
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int i = 0, j = 0;
        int windows = 0, res = 0;
        while (j < m){
            if (nums[j] >= k){
                windows++;
            }
            j++;
        }
        if (windows == m){
            res++;
        }
        while (j < n){
            if (nums[i++] >= k){
                windows--;
            }
            if (nums[j++] >= k){
                windows++;
            }
            if (windows == m){
                res++;
            }
        }
        System.out.println(res);

    }
}
