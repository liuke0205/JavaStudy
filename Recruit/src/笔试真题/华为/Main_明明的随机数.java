package 笔试真题.华为;

import java.util.Scanner;

public class Main_明明的随机数 {
    /**
     * https://www.nowcoder.com/questionTerminal/fe298c55694f4ed39e256170ff2c205f
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[501];
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
            nums[ints[i]] = 1;
        }
        for (int i = 1; i <= 500; i++) {
            if (nums[i] == 1){
                System.out.println(i);
            }
        }
    }
}
