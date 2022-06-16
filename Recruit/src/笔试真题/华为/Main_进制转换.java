package 笔试真题.华为;

import java.util.Scanner;

public class Main_进制转换 {
    /**
     * https://www.nowcoder.com/questionTerminal/8f3df50d2b9043208c5eed283d1d4da6
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        long num = 0L;
        int idx = 0;
        for (int i = str.length() - 1; i > 1; i--) {
            num += fun(str.charAt(i)) * Math.pow(16, idx++);
        }
        System.out.println(num);
    }

    public static int fun(char c){
        if (c >= '0' && c <= '9'){
            return c - '0';
        }
        return c - 'A' + 10;
    }
}
