package 笔试真题.快手;

import java.util.Scanner;

public class Main_获得最多的奖金 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long max = 0;
        int i= 0, j = nums.length - 1;
        long leftSum = nums[i], rightSum = nums[j];
        while (i < j){
            if (leftSum < rightSum){
                i++;
                leftSum += nums[i];
            }else if (leftSum > rightSum){
                j--;
                rightSum += nums[j];
            }else {
                max = Math.max(max, leftSum);
                i++;
                j--;
                leftSum += nums[i];
                rightSum += nums[j];
            }
        }
        System.out.println(max);
    }


}
