package guosai;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/27 1:01
 */
public class Main_123 {
    static int N = 1414214;
    static long[] sum = new long[N + 1];

    static {
        long sn = 0;
        for (int i = 1; i <= N; ++i) {
            sn += i;
            sum[i] = sum[i - 1] + sn;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0){
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            System.out.println(sum(left, right));
        }
    }

    static long sum(long l, long r) {return getSum(r) - getSum(l - 1);}

    static long getSum(long i) {
        int n = binarySearch(i);
        int m = (int) (i - f(n - 1));
        return sum[n - 1] + f(m);
    }

    static int binarySearch(long target) {
        int l = 1;
        int r = N;
        while (l < r) {
            int mid = l + r >> 1;
            if (f(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    /* 1~n的和 */
    static long f(int n) {return (1L + n) * n / 2;}

    // main...遍历输入的l,r调用sum(l,r)进行计算
}
