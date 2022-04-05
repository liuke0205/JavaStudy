package 笔试真题.招商银行;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/4 0:09
 */
public class Solution_鸡鸭分类问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(Math.min(fun(str,'C', 'D'), fun(str, 'D', 'C')));
    }


    public static int fun(String str, char a,char b){
        int num = 0;
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length - 1;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] == a && arr[j + 1] == b) {
                    arr[j] = b;
                    arr[j + 1] = a;
                    num++;
                }
            }
        }
        return num;
    }
}
