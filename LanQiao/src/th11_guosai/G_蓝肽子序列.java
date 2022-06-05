package th11_guosai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/5 22:24
 */
public class G_蓝肽子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        List<String> list1 = fun(str1);
        List<String> list2 = fun(str2);
        int[][] dp = new int[list1.size() + 1][list2.size() + 1];
        for (int i = 1; i <= list1.size(); i++) {
            for (int j = 1; j <= list2.size(); j++) {
                if (list1.get(i - 1).equals(list2.get(j - 1))){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[list1.size()][list2.size()]);
    }

    public static List<String> fun(String str){
        List<String> res= new ArrayList<>();
        int start= 0, end = 0;
        for (char c : str.toCharArray()){
            if (c >= 'A' && c <= 'Z'){
                if (start != end)
                    res.add(str.substring(start, end));
                start = end;
            }
            end++;
        }
        res.add(str.substring(start, end));
        return res;
    }
}
