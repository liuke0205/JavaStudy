package 笔试真题.美团;

import java.util.*;

public class Main_公司食堂 {
    /**
     * https://www.nowcoder.com/questionTerminal/601815bea5544f389bcd20fb5ebca6a8
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            scanner.nextInt();
            String[] nums = scanner.next().split("");

            PriorityQueue<Integer> zero = new PriorityQueue<>();
            PriorityQueue<Integer> one = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                if ("0".equals(nums[i])){
                    zero.add(i + 1);
                }else if ("1".equals(nums[i])){
                    one.add(i + 1);
                }
            }
            scanner.nextInt();
            String sex = scanner.next();
            fun(zero, one, sex.toCharArray());
        }
    }

    public static void fun(PriorityQueue<Integer> zero, PriorityQueue<Integer> one, char[] sex){
        for (char c: sex) {
            if (c == 'M'){//男
                if (!one.isEmpty()){
                    int one_idx = one.poll();
                    System.out.println(one_idx);
                }else {
                    int zero_idx = zero.poll();
                    System.out.println(zero_idx);
                    one.add(zero_idx);
                }
            }else {//女
                if (!zero.isEmpty()){
                    int zero_idx = zero.poll();
                    System.out.println(zero_idx);
                    one.add(zero_idx);
                }else {
                    int one_idx = one.poll();
                    System.out.println(one_idx);
                }
            }
        }
    }
}
