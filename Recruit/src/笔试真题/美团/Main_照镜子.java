package 笔试真题.美团;

import java.util.Scanner;

public class Main_照镜子 {
    /**
     * https://www.nowcoder.com/questionTerminal/55681b7896b64b289def24022480109f?f=discussion
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
            sb.append(nums[i][0]);
        }
        int res;
        if (n < 2){
            res = n;
        }
        String str = sb.toString();
        res = n;
        while (isHuiWen(str, res)){
            res /= 2;
        }
        for (int i = 0; i < res; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isHuiWen(String str, int len){
        int i = 0, j = len - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
