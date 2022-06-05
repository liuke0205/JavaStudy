package 笔试真题.快手;

import java.util.Arrays;
import java.util.Scanner;

public class Main_搭积木 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (o1, o2)->{
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i][1];
        }
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] >= nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
