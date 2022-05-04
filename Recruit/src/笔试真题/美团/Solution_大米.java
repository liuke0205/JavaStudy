package 笔试真题.美团;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author liuke
 * @date 2022/4/30 11:28
 */
public class Solution_大米 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 车辆数和大米数
        int n = scan.nextInt();
        int m = scan.nextInt();
        long[] nums = new long[n];
        long[] pre = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
            pre[i] = sum;
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (m + pre[j] - pre[i] + nums[i] >= 0){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        System.out.println(max);
    }
}
