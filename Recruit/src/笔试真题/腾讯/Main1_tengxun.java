package 笔试真题.腾讯;

import java.util.*;

public class Main1_tengxun {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
            m = strings[i].length();
        }
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = strings[i].toCharArray();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (flag && arr[j][i] == '0'){
                    continue;
                }
                sum = sum * 10 + (arr[j][i] - '0');
                if (arr[j][i] != '0'){
                    flag = false;
                }
            }
            list.add(sum);
        }
        Collections.sort(list);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}



