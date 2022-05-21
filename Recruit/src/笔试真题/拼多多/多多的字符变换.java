package 笔试真题.拼多多;

import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/18 22:48
 */
public class 多多的字符变换 {
    /**
     * 因为交换字符没有代价，所以将两个字符串分别排序然后逐位比较计算代价即可
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] a1 = scanner.next().toCharArray();
        char[] a2 = scanner.next().toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(a1[i] - a2[i]);
        }
        System.out.println(res);
    }
}
