package 笔试真题.Shoope;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/6/4 0:11
 */
public class Main_最小金额购买商品 {
    /**
     * https://www.nowcoder.com/questionTerminal/c6404089eeaa4530b0a259d97e31be6f
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(cost(new int[]{1,0,2}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public static int cost (int[] array) {
        int length = array.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < length; i++) {
            if (array[i] > array[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (array[i] > array[i+1]){
                right[i] = right[i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
