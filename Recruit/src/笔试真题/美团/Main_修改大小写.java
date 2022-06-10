package 笔试真题.美团;

import java.util.Scanner;

public class Main_修改大小写 {
    /**
     * https://www.nowcoder.com/questionTerminal/a3522ae8c2b24ad4a03f31100d3cbfa7
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int a = 0, b = 0;
        for(char c : str.toCharArray()){
            if (c >= 'a' && c <= 'z'){
                a++;
            }else {
                b++;
            }
        }
        System.out.println(Math.abs(a-b)/2);
    }
}
