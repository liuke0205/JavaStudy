package 笔试真题.腾讯;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main3_TENGX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        System.out.println(getResult(n, arr, '0', '1'));
    }

    public static int getResult(int n, char[] arr, char c1, char c2){
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == c1){
                sumA += i + 1;
            }
            A[i+1] = sumA;
        }
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] == c2){
                sumB += i + 1;
            }
            B[i] = sumB;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n +1; i++) {
            min = Math.min(min, Math.abs(A[i] - B[i]));
        }
        return min;
    }
}
