package 笔试真题.腾讯;

import java.util.Stack;

/**
 * @author liuke
 * @date 2022/4/23 23:28
 */
public class Solution_压缩算法 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串
     */
    public String compress (String str) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        int left = 0, right = 0, sum = 0;
        for (char c : str.toCharArray()) {
            if (isNumber(c)){
                sum = sum * 10 + (c - '0');
                continue;
            }
            if (sum != 0){
                integers.add(sum);
                sum= 0;
            }

            if (c == '['){
                left++;
            }else if (c == ']'){
                right++;
            }else{

            }
        }
        return "";
    }

    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }


    public static void main(String[] args) {

    }

}
