package com.liuke;

import java.util.Locale;

/**
 * @author liuke
 * @date 2022/3/18 14:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(fun("ab34de59"));
    }

    public static String fun(String str){
        char[] arr = str.toCharArray();

        int i = 0, j = arr.length - 1;
        while (i < j){
            if (!isZiMu(arr[i])){
                i++;
            }
            if ((!isZiMu(arr[j]))){
                j--;
            }
            if (isZiMu(arr[i]) && isZiMu(arr[j])){
                swap(arr, i , j);
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isZiMu(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
