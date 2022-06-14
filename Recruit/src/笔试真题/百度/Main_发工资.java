package 笔试真题.百度;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_发工资 {
    /**
     * https://www.nowcoder.com/questionTerminal/e47cffeef25d43e3b16c11c9b28ac7e8
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> money = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int cnt = scanner.nextInt();
            for (int j = 0; j < cnt; j++) {
                money.add(p);
            }
        }
        Collections.sort(money);
        int cnt = 0;
        int i = 0, j = money.size() - 1;
        while (i < j){
            if (money.get(j) >= m){
                cnt++;
                j--;
            }else if (money.get(j) + money.get(i) >= m){
                cnt++;
                j--;
                i++;
            }else {
                i++;
            }
        }
        if (money.get(i) >= m){
            cnt++;
        }
        System.out.println(cnt);
    }
}
