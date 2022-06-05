package 笔试真题.快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 18:24
 */
public class Main_字母组合 {
    static String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        dfs(str, 0, sb);
        System.out.println(res.toString());
    }

    public static void dfs(String str, int idx, StringBuilder path){
        if (idx == str.length()){
            res.add(path.toString());
            return;
        }
        int num = str.charAt(idx) - '0';
        for (int i = 0; i < phone[num].length(); i++) {
            path.append(phone[num].charAt(i));
            dfs(str, idx+1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
