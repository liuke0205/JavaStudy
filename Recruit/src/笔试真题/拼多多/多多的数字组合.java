package 笔试真题.拼多多;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/18 22:35
 */
public class 多多的数字组合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N < 0 || N > 45){
            System.out.println(-1);
            return;
        }
        List<Integer> res = new ArrayList<>();
        int num = 9;
        while (N > 0){
            if (N >= num){
                res.add(0, num);
                N -= num--;
            }else {
                res.add(0, N);
                N = 0;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }
}
