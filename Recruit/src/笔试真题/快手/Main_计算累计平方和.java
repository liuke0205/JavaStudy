package 笔试真题.快手;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 0:04
 */
public class Main_计算累计平方和 {
    /**
     * https://www.nowcoder.com/questionTerminal/c8cfc98711a14a3fbc587ca5aabc09ee
     * 1.快慢指针
     * 2.使用set集合记录之前的值，如果重复出现说明出现了环
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int m = scanner.nextInt();
            int slow = m;
            int fast = getNext(m);
            while (slow != fast && fast != 1){
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            System.out.println(fast == 1 ? "true" : "false");
        }
    }

    public static int getNext(int num){
        int sum = 0;
        while (num != 0){
            long a= num % 10;
            sum += a * a;
            num /= 10;
        }
        return sum;
    }
}
