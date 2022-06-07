package 笔试真题.Shoope;

import java.util.Arrays;

public class Main_最大正整数 {
    public static void main(String[] args) {

    }
    public int maxIntValue (int[] arrs) {
        Arrays.sort(arrs);
        int sum = 0;
        for (int i = arrs.length - 1; i >= 0; i--) {
            sum = sum * 10 + arrs[i];
        }
        return sum;
    }
}
