package 笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 0:39
 */
public class 两两配对差值最小 {
    /**
     * https://www.nowcoder.com/questionTerminal/60594521f1db4d75ad78266b0b35cfbb
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int i = 0, j = arr.length - 1;
        while (i < j){
            int num = arr[i] + arr[j];
            min = Math.min(min, num);
            max = Math.max(max, num);
            i++;
            j--;
        }
        System.out.println(max - min);
    }
}
