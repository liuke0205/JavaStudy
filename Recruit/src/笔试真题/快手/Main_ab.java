package 笔试真题.快手;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Handler;

public class Main_ab {
    /**
     * https://www.nowcoder.com/questionTerminal/1df03f0989a1494fa2acfcbd43496ffd
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        // 先求出整数部分
        result.append(a / b);
        // 如果有小数部分再求小数部分
        if (a % b != 0) {
            a = a % b;
            result.append('.');
            // 使用hashmap记录每一个被除数和它上一次出现的位置
            HashMap<Integer, Integer> map = new HashMap<>();
            while (a != 0) {
                a *= 10; // 新的被除数
                if (map.get(a) != null) { // 如果这个被除数曾经出现过，那么找到了循环节，游戏结束
                    // 在上一次此被除数出现的位置之前插入'('
                    result.insert(map.get(a), "(");
                    // 在最后插入')'
                    result.append(')');
                    break;
                }

                // 没有出现过就将此被除数插入map
                map.put(a, result.length());

                // 求出商和余数
                result.append(a / b);
                a = a % b;
            }
        }

        // 输出结果
        System.out.println(result);
    }
}
