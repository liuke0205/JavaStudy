package 笔试真题.快手;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 0:46
 */
public class Main_合并内容流 {
    /**
     * https://www.nowcoder.com/questionTerminal/0f3bdc60198244d9a8893b843afd2310
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        String[] chars = scanner.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < nums.length && j < chars.length) {
            for (int k = 0; k < 4 && i < nums.length; k++) {
                sb.append(nums[i++]).append(" ");
            }
            sb.append(chars[j++]).append(" ");
        }
        while (i < nums.length){
            sb.append(nums[i++]).append(" ");
        }
        while (j < chars.length){
            sb.append(chars[j++]).append(" ");
        }
        String res = sb.toString().trim();
        System.out.println(res);
    }
}
