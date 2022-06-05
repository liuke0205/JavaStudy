package 笔试真题.快手;

import java.util.Scanner;

public class Main_将满二叉树转换为求和树 {
    /**
     * https://www.nowcoder.com/questionTerminal/b31734e46ba644de85a9cf95bbd57a5f
     */
    static int[] res;
    static int length;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        String[] s2 = scanner.nextLine().split(" ");
        length = s2.length;
        int[] nums = new int[length];
        res = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        fun(nums, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    // 返回当前节点和其子树之和，中间过程统计当前节点的子树之和（不包括当前节点）
    public static int fun(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        if (left > right){
            return 0;
        }
        int mid = (right + left) / 2;
        int leftSum = fun(nums, left, mid - 1);
        int rightSum = fun(nums, mid + 1, right);
        res[mid] = leftSum + rightSum;
        return res[mid] + nums[mid];
    }
}
