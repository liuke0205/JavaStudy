package guosai;

import java.util.ArrayList;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main_质数拆分 {
    public static boolean is(int n){
        for (int i = 2; i < n; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 2; i <= 2019; i++) {
            if (is(i)){
                arrayList.add(i);
            }
        }
        /*
            55965365465060
         */
        long[][] dp = new long[arrayList.size()][2019+1];
        for (int i = 0; i < 2020; i++) {
            if (arrayList.get(0)==i){
                //当拆分数为i，拆分个数为1的时候当且仅当i等于拆分数是才可以
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            //当拆分数为0的时候应该有一种情况
            dp[i][0] = 1;
        }

        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = 0; j < 2020; j++) {
                if (j>=arrayList.get(i)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arrayList.get(i)];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[arrayList.size()-1][2019]);
        scan.close();
    }
}