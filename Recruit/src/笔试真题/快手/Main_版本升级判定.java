package 笔试真题.快手;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 0:23
 */
public class Main_版本升级判定 {
    /**
     * https://www.nowcoder.com/questionTerminal/13b28e18f470491e9d4d19de3ab5cf26?toCommentId=5629653
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String[] str = scanner.nextLine().split(" ");
            String[] a1 = str[0].split("\\.");
            String[] a2 = str[1].split("\\.");
            if (getResult(a1, a2)){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }

    private static boolean getResult(String[] a1, String[] a2) {
        int[] v1 = new int[4];
        int[] v2 = new int[4];
        for (int i = 0; i < a1.length; i++) {
            v1[i] = Integer.parseInt(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            v2[i] = Integer.parseInt(a2[i]);
        }
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] < v2[i]){
                return true;
            }else if (v1[i] > v2[i]){
                return false;
            }
        }
        return false;
    }
}
