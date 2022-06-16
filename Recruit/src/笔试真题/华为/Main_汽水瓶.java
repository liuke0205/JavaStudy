package 笔试真题.华为;

import java.util.Scanner;

public class Main_汽水瓶 {
    /**
     * https://www.nowcoder.com/questionTerminal/fe298c55694f4ed39e256170ff2c205f
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n == 0){
                break;
            }
            int res = 0;
            while (n > 1){
                if (n == 2){
                    res++;
                    break;
                }else {
                    int num = n / 3;
                    res += num;
                    n -= num * 3;
                    n += num;
                }
            }
            System.out.println(res);
        }
    }
}
