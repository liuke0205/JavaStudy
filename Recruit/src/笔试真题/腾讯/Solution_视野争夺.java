package 笔试真题.腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/24 0:50
 */
public class Solution_视野争夺 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        System.out.println(fun(arr, n, L));
    }

    public static int fun(int[][] arr,int n, int L){
        // 先按照头升序，当头相等时按照尾降序
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        if (arr[0][0] != 0){
            return -1;
        }
        int cnt = 0, idx = 0, curEnd = 0, nextEnd = 0;
        while (idx < n && arr[idx][0] <= curEnd){
            // 在第idx的区间[0， curEnd]上寻找结束最大的区间
            while (idx < n && arr[idx][0] <= curEnd){
                nextEnd =  Math.max(nextEnd, arr[idx][1]);
                idx++;
            }
            cnt++;
            curEnd = nextEnd;
            if (curEnd >= L){
                return cnt;
            }
        }
        return -1;
    }
}
