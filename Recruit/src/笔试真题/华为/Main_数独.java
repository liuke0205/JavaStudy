package 笔试真题.华为;

import java.util.Scanner;

public class Main_数独 {
    /**
     * https://www.nowcoder.com/questionTerminal/2b8fa028f136425a94e1a733e92f60dd
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] nums = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        dfs(nums);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean dfs(int[][] nums) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (nums[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (check(nums, i, j, k)) {
                        nums[i][j] = k;
                        if (dfs(nums)) {
                            return true;
                        }
                        nums[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static boolean check(int[][] board, int i, int j, int k) {
        // 判断当前位置的i行是否有k
        for (int l = 0; l < board[0].length; l++) {
            if (board[i][l] == k) {
                return false;
            }
        }

        // 判断当前位置的j列是否有k
        for (int l = 0; l < board.length; l++) {
            if (board[l][j] == k) {
                return false;
            }
        }

        // 判断当前9宫格中是否有k
        int startI = (i / 3) * 3;
        int startJ = (j / 3) * 3;
        for (int l = startI; l < startI + 3; l++) {
            for (int m = startJ; m < startJ + 3; m++) {
                if (board[l][m] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}