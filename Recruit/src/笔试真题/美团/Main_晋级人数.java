package 笔试真题.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/7 23:19
 */
public class Main_晋级人数 {
    /**
     * https://www.nowcoder.com/questionTerminal/31a1d7926cd947cc907de60ba8192b6c
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int base = nums[n - x];
        int cnt = 0;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > 0 && nums[i] >= base){
                cnt++;
            }else {
                break;
            }
        }
        System.out.println(cnt);
    }
}
