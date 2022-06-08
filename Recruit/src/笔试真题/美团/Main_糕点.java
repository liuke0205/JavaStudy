package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/7 23:11
 */
public class Main_糕点 {
    /**
     * https://www.nowcoder.com/questionTerminal/10661f4d02564ba686bcba4645e0a029
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int min = Math.min(a, b), max = Math.max(a, b);
                int min_cnt = 0, max_cnt = 0;
                int[] nums = new int[m];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = scanner.nextInt();
                    if (nums[i] == max) {
                        max_cnt++;
                    }
                    if (nums[i] == min) {
                        min_cnt++;
                    }
                }
                System.out.println(fun(max_cnt, min_cnt, n, m, nums, max, min));
            }catch (Exception e){
                break;
            }
        }
    }

    public static String fun(int max_cnt, int min_cnt, int n, int m, int[] nums, int max, int min){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min || nums[i] > max) {
                return "NO";
            }
            if (nums[i] == max) {
                max_cnt++;
            }
            if (nums[i] == min) {
                min_cnt++;
            }
        }
        if (max_cnt > 0 && min_cnt > 0){
            return "YES";
        }
        int cnt = 0;
        if (max_cnt == 0)cnt++;
        if (min_cnt == 0)cnt++;
        if (cnt <= n - m){
            return "YES";
        }else {
            return "NO";
        }
    }
}
