package 笔试真题.快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_病毒检测2 {
    /**
     * 链接：
     * https://www.nowcoder.com/questionTerminal/6f0d16fc06274f44af8913d182668037
     *
     * 思路:
     * 使用两个辅助vector，一个记录1的位置v1，一个记录某个1的前面0的数量v2，
     * 用一个长度为k的窗口在v1上滑动;
     * 然后第n个1的左边的0的个数为a，第n + k个1的右边的0的个数为b，
     * 那么这个组合有（a + 1） * （b + 1）种可能，
     * 将所有可能加起来就可以了。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.next();
        int len = str.length();
        List<Integer> idx_1 = new ArrayList<>();
        List<Integer> sum_0 = new ArrayList<>();
        int cnt_0 = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '1'){
                idx_1.add(i);
                sum_0.add(cnt_0);
                cnt_0 = 0;
            }else {
                cnt_0++;
            }
        }
        if (str.charAt(str.length() - 1) == '0'){
            sum_0.add(cnt_0);
        }else {
            sum_0.add(0);
        }

        long res = 0;

        if (k == 0){
            for (int i = 0; i < sum_0.size(); i++) {
                long num = sum_0.get(i);
                res += (1 + num) * num / 2;
            }
        }else if (k > idx_1.size()){
        }else {
            for (int i = 0, j = k-1; j < idx_1.size(); i++, j++) {
                res += (long) (sum_0.get(i) + 1) * (sum_0.get(j + 1) + 1);
            }
        }
        System.out.println(res);
    }
}
