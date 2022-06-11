package guosai;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/11 19:17
 */
public class Main_递增序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] nums = new char[30][50];
        for (int i = 0; i < 30; i++) {
            nums[i] = scanner.nextLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 30; k++) {
                    for (int l = 0; l < 50; l++) {
                        if (nums[k][l] > nums[i][j]){
                            // 同行
                            if ((k == i && l > j) || (l == j && k > i) || (Math.abs(k-i) == Math.abs(l-j) && !(k <= i && l <= j))){
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
