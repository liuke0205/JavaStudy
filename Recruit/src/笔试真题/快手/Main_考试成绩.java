package 笔试真题.快手;

import java.util.HashMap;
import java.util.Scanner;

public class Main_考试成绩 {
    /**
     * https://www.nowcoder.com/questionTerminal/65429b39865a4d4a8fd11ea1c7bcb7ce
     * 贪心思想
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        char[][] nums = new char[n][m];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLine().toCharArray();
        }
        String[] score = scanner.nextLine().split(" ");
        int sum = 0;
        for (int i = 0; i < m; i++) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;

            for (int j = 0; j < n; j++) {
                map.put(nums[j][i], map.getOrDefault(nums[j][i], 0) + 1);
                max = Math.max(max, map.get(nums[j][i]));
            }
            sum += max * Integer.parseInt(score[i]);
        }
        System.out.println(sum);
    }
}
