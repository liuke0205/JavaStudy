package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 23:29
 */
public class 大整数相乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sts = s.split(" ");
        String str1 = sts[0], str2 = sts[1];
        if (str1.equals("0") || str2.equals("0")){
            System.out.println("0");
            return;
        }
        int idx = 0;
        String res = "";
        for (int i = str2.length() - 1; i >= 0; i--) {
            String temp = mulit(str1, str2.charAt(i), idx++);
            res = add(temp, res);
        }
        System.out.println(res);
    }

    public static String mulit(String str, char c, int cnt){
        // 加后置cnt个0
        StringBuilder res = new StringBuilder();
        while (cnt-- > 0){
            res.append("0");
        }
        int sum = 0, i = str.length() - 1;
        while (i >= 0 || sum > 0){
            sum += (i >= 0 ? str.charAt(i--) - '0' : 0) * (c - '0');
            res.append(sum % 10);
            sum /= 10;
        }
        return res.reverse().toString();
    }

    public static String add(String str1, String str2){
        int sum = 0;
        int i = str1.length() - 1, j = str2.length() - 1;
        StringBuilder num = new StringBuilder();
        while (i >= 0 || j >= 0 || sum > 0){
            int num1 = (i >= 0 ? str1.charAt(i--) - '0' : 0);
            int num2 = (j >= 0 ? str2.charAt(j--) - '0' : 0);
            sum += num1 + num2;
            num.append(sum % 10);
            sum /= 10;
        }
        return num.reverse().toString();
    }
}
