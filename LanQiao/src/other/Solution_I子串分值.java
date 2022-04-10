package other;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/4 1:18
 */
public class Solution_I子串分值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int cnt  = 0;
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            int i = k - 1;
            while (i >= 0){
                if (c != s.charAt(i)){
                    i--;
                }else {
                    break;
                }
            }
            int leftNum = k - i;

            int j = k + 1;
            while (j <= s.length() - 1){
                if (c != s.charAt(j)){
                    j++;
                }else {
                    break;
                }
            }
            int rightNum = j - k;

            cnt += leftNum * rightNum;
        }
        System.out.println(cnt);
    }
}
