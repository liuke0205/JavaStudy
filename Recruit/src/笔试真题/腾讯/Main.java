package 笔试真题.腾讯;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int numStack = 0, cur = m;
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] >= arr[i]){
                if (cur >= arr[i]){
                    numStack++;
                    cur -= arr[i];
                }
            }
            else {
                if (numStack > 0){
                    cur +=numStack * arr[i];
                    numStack = 0;
                }
            }
        }
        if (numStack > 0){
            cur += numStack * arr[n-1];
        }
        System.out.println(cur);
    }
}
