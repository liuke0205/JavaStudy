package 笔试真题.拼多多;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/21 0:00
 */
public class Solution_二维表第k大数 {
    /**
     * https://www.nowcoder.com/questionTerminal/98929bfe8f6b4beba5838285ae99aa6f
     *
     * 思路：
     * 1. 二分法， 将第 k 大转化为第 p 小
     * 2. 求出mid后，找出当前比mid小的个数
     *    rows = mid / m 得到比mid小的行数 -> cnt = rows * n
     *    然后从rows + 1行开始，找出每行比mid小的元素个数 cnt += mid / row
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int p = n * m - k + 1;
        int left = 1, right = n * m;
        while (left < right){
            int mid = (right - left) / 2 + left;
            int row = mid / m;
            int cnt = row * m;
            for (int i = row + 1; i <= n; i++) {
                cnt += mid / i;
            }
            if (cnt < p){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
