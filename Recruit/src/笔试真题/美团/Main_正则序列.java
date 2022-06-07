package 笔试真题.美团;


import java.util.Arrays;
import java.util.Scanner;
public class Main_正则序列 {
    /**
     * https://www.nowcoder.com/questionTerminal/0771ab500d424415af6b1aa4c13afcdd
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(i+1-nums[i]);
        }
        System.out.println(sum);
    }
}

