package 笔试真题.快手;

import java.util.Scanner;

public class Main_病毒检测 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.next();
        int len = str.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 0, j = i;

            for (; j < len; j++) {
                char c = str.charAt(j);
                if(c == '1'){
                    cnt++;
                }
                if (cnt == k){
                    res++;
                    break;
                }
            }

            while (++j < len){
                if (str.charAt(j) == '1'){
                    break;
                }else {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
