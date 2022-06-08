package 笔试真题.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main_搭配出售 {
    /**
     * https://www.nowcoder.com/questionTerminal/02a76c341e6d4cf5a1467ea9b3d6ec3b
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        Node[] nums = new Node[3];
        nums[0] = new Node(a, scanner.nextInt());
        nums[1] = new Node(b, scanner.nextInt());
        nums[2] = new Node(c, scanner.nextInt());
        Arrays.sort(nums, (o1, o2) -> {
            return o2.money - o1.money;
        });
        // 直接用long
        long sum = 0;
        for (int i = 0; i < 3 && d > 0; i++) {
            if (nums[i].num <= d){
                sum += (long) nums[i].money * nums[i].num;
                d -= nums[i].num;
            }else {
                sum += (long) nums[i].money * d;
                d = 0;
            }
        }
        System.out.println(sum);
    }

    static class Node{
        int num, money;
        public Node(int num, int money){
            this.num = num;
            this.money = money;
        }
    }
}
