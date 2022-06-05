package 笔试真题.腾讯;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/28 0:04
 */
public class Main_01串的价值 {
    /**
     * https://www.nowcoder.com/questionTerminal/16976852ad2f4e26a1ff9f555234cab2
     * @param args
     */
    public static void main(String[] args) {
        //1. 找出元素最多的数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        //2. 找出最大元素的左右边界
        System.out.println(Math.max(max('0', str), max('1', str)));
    }

    public static int max(char max_c, String str){
        int left = 0, right = str.length()-1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == max_c){
                left = i;
                break;
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == max_c){
                right = i;
                break;
            }
        }

        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (str.charAt(i) != max_c){
                cnt++;
            }
        }

        int max = Math.max(fun(left), fun(str.length() - right - 1));
        return fun(right - left - cnt + 1) + max;
    }

    public static int fun(int len){
        return (1 + len) * len / 2;
    }
}
