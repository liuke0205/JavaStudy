package 笔试真题.快手;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 20:46
 */
public class Main_最长等差数列问题 {
    /**
     * https://www.nowcoder.com/questionTerminal/4031f5a3723542e78a45b490c84c62b2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sub = nums[j] - nums[i];
                int cnt = 2, pre = j;
                for (int k = j+1; k < n; k++) {
                    if (nums[k] - nums[pre] == sub){
                        cnt++;
                        pre = k;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}
