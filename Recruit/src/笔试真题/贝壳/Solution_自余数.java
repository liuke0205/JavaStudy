package 笔试真题.贝壳;

import java.util.Scanner;

public class Solution_自余数 {
    /**
     * 自余数的定义为若满足 n % S(n) == 1，则称n为自余数。S(n)为n各个位上数字之和
     * 现在要求区间[l, r]之间有多少个自余数
     *
     * 输入：
     * 第一行为t，表示有t组数据
     * 接下来有t行，每一行有两个证书l, r
     *
     * 输出：
     * t行，每行为一组的答案
     *
     */
    static int[] memo = new int[1000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int res = 0;
            int l = sc.nextInt();
            int r = sc.nextInt();
            for (int i = l; i <= r; i++) {
                if (memo[i] == 1){
                    res++;
                }else if (memo[i] == -1){
                }else {
                    boolean flag = (i % getSum(i) == 1);
                    if (flag){
                        res++;
                    }
                    memo[i] = flag ? 1 : -1;
                }
            }
            System.out.println(res);
        }
    }

    public static int getSum(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * 3
     * 11 11
     * 13 13
     * 1 20
     */
}