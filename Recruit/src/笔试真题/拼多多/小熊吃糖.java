package 笔试真题.拼多多;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author liuke
 * @date 2022/5/22 16:53
 */
public class 小熊吃糖 {
    /**
     * https://www.nowcoder.com/questionTerminal/dc49df3bbc0146dd92322889d40afcb1
     *
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] sugar = new int[m];
        for (int i = 0; i < m; i++) {
            sugar[i] = scanner.nextInt();
        }

        // 按照小熊的战斗力降序排列
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o2.priority - o1.priority);

        for (int i = 0; i < n; i++) {
            heap.add(new Node(i, scanner.nextInt(), scanner.nextInt()));
        }

        Arrays.sort(sugar);
        Node[] nums = new Node[n];
        int idx = 0;

        while (!heap.isEmpty()){
            Node node = heap.poll();
            for (int j = m-1; j >= 0; j--) {
                if (sugar[j] > 0 && node.val >= sugar[j]){
                    node.val -= sugar[j];
                    sugar[j] = 0;
                }
            }
            nums[idx++] = node;
        }

        Arrays.sort(nums, ((o1, o2) -> o1.idx - o2.idx));
        for (Node node : nums) {
            System.out.println(node.val);
        }
    }

    static class Node{
        int idx; // 代表原来的顺序
        int priority;
        int val;
        public Node(int idx, int priority, int val){
            this.idx = idx;
            this.priority = priority;
            this.val = val;
        }
    }
}
