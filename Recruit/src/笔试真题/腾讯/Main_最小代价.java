package 笔试真题.腾讯;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main_最小代价 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(scanner.nextInt(), 0);
        }
        for (int i = 0; i < n; i++) {
            nodes[i].money = scanner.nextInt();
        }
        Arrays.sort(nodes, (o1, o2)->{
            if (o1.num == o2.num){
                return o1.money - o2.money;
            }
            return o1.num - o2.num;
        });
        int res = 0;
        while (!check(nodes)){
            // 找出当前序列中num最小的重复数
            int[] minNum = getMinNum(nodes);
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].num == minNum[0]){
                    res += nodes[i].money * (minNum[1]-1);
                    minNum[1]--;
                }
            }
        }
    }

    public static int[] getMinNum(Node[] nums){
        int[] arr = new int[100001];
        for(Node num : nums){
            arr[num.num]+=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1){
                return new int[]{i, arr[i]};
            }
        }
        return new int[]{-1, -1};
    }

    // 检查元素是否各不相同，如果各不相同返回true
    public static boolean check(Node[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i].num);
        }
        return set.size() == nums.length;
    }

    static class Node{
        int num, money;
        public Node(int num, int money){
            this.num = num;
            this.money = money;
        }
    }
}