package 笔试真题.美团;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/19 12:36
 */
public class Solution_魔法盒子 {
    /**
     * 对于一个序列A，我们定义序列(A+1)为将序列A里每个元素值都加1得到
     * 例如: [3,4, 2]+1=[4,5, 3], [1,2, 1]+1=[2, 3, 2]。
     * 对于序列A和B，我们定义序列C=A*B表示序列C是由序列A和序列B拼措
     * 例如: [2,3, 1]*[1,2, 1]=[2,3,1, 1,2, 1];
     * [1, 2, 3]*[2, 3]*[5, 4]=[1, 2, 3, 2, 3]*[5, 4]=[1, 2,3,2,3, 5, 4]。
     * 小团得到了一个魔法盒子。
     * 将序列A放入魔法盒子内，将会弹出序列(A+1)*A*(A+2)。
     * 小团先将仅由一个数0构成的序列[0]放入魔法盒子，然后不断将魔法盒子
     * 这样操作第n次时魔法盒子弹出序列中第k个位置的值是多少2
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = fun(n , k);
        System.out.println(result);
    }

    private static int fun(int n, int k) {
        if (n == 0){
            return 0;
        }
        int num = (int) Math.pow(3, n - 1);
        if (k >= num +1 && k <= num * 2){
            return fun(n-1, k - num);
        }else if (k >= 1 && k <= num){
            return 1 + fun(n - 1, k);
        }else {
            return 2 + fun(n-1, k - 2 * num);
        }
    }
}
