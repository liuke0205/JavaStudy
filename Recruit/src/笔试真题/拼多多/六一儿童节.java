package 笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/23 0:19
 */
public class 六一儿童节 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = scanner.nextInt();
        }
        // 巧克力的大小
        Arrays.sort(h);
        // 孩子的需求
        Arrays.sort(w);
        int cnt = 0;
        for (int i = h.length - 1, j = w.length - 1; i >= 0 && j >= 0; i--) {
            if (w[j] >= h[i]){
                cnt++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}
