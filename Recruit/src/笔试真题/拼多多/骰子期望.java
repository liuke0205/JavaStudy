package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/21 11:11
 */
public class 骰子期望 {
    /**
     * https://www.nowcoder.com/questionTerminal/86ef0d5042934ef7819035794377a507
     *
     * 思路：
     * 对于最终结果k，只要n个骰子中有一个掷出了k，其余的点数均小于等于k，那最终结果就是k。
     * A.计所有骰子的点数都不超过k的概率为P(x<=k)
     * B.计所有骰子的点数都小于k的概率为P(x<=k-1)
     * 很明显，事件A是包含事件B的，最终结果为k（即事件A-B）的概率为P(x=k)=P(x<=k)-P(x<=k-1)。
     * 而对于一组骰子X=[X1,X2,...,Xn]，最终结果的可能取值就是[1,max(X)]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
        }
        double res = 0.0, pre = 0.0;
        for (int k = 1; k <= max; k++) {
            // P(x=k) = P(x<=k) - P(x<=k-1)
            double cur = 1.0;
            for (int i = 0; i < n; i++) {
                cur *= Math.min(arr[i], k) * 1.0 / arr[i];
            }
            res += (cur - pre) * k;
            pre = cur;
        }
        // 格式化输出
        System.out.printf("%.2f", res);
    }
}
