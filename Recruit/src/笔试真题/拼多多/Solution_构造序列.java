package 笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/20 23:25
 */
public class Solution_构造序列 {
    /**
     * 给定一个01序列 A 和 一个整数K. 多多有一个构造等长序列B的方法。对于B中的第i个位置的值，可以按照以下方式生成：
     * a. 如果A[i-k] 等于1，其中i>=k，则B[i]的值为1
     * b. 或者A[i+k] 等于1，其中i+k < |A|,则B[i]的值为1
     * c. 否则B[i]的值为0
     *
     * 现在已知序列B 和 整数k，多多希望帮忙把A序列还原出来
     *
     * 输入：共两行
     * 第一行，一个整数k
     * 第二行，表示序列B
     *
     * 输出：一行，表示序列A（存在多个，输出字典序最小的）
     *
     * 2
     * 101110
     *
     * 001011
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.next();
        char[] B = str.toCharArray();
        char[] A = new char[B.length];
        Arrays.fill(A, '0');
        for (int i = 0; i < B.length; i++) {
            if (B[i] == '1'){
                if (i >= k){
                    A[i-k] = '1';
                    continue;
                }
                if (i + k < B.length){
                    A[i+k] = '1';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }
        System.out.println(sb.toString());
    }
}
