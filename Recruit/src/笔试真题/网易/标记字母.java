package 笔试真题.网易;

import java.util.Scanner;

public class 标记字母 {
    /**
     * 小红拿到一个字符串，她可以做任意次以下操作：
     * 标记这个字符串两个位置相邻的字母，并且这两个字母必须满足以下条件才可标记：
     * 两个字母相同 或者 两个字母在字母表中相邻，小红可以获得这两个字母的分数
     *
     * 举例：'a' 和 'b' 相邻，那么可以获得3分。
     *
     * 已经被标记的字母无法被重复标记。
     * 小红想知道，自己最多能够获得多少分？
     *
     * 输入：abdbb
     *
     * 输出：7
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(result(sc.next()));
    }

    public static int result(String s){
        char[] arr = s.toCharArray();
        int[] f = new int[s.length() + 2];
        for (int i = 1; i < s.length(); i++) {
            if ( match(arr[i], arr[i-1])){
                f[i] = Math.max(f[i-1], ((i-2>=0) ? f[i-2] : 0) + getNum(arr[i-1]) + getNum(arr[i]));
            }else {
                f[i] = f[i-1];
            }
        }
        return f[s.length() - 1];
    }

    public static boolean match(char c1, char c2){
        return c1 == c2 || Math.abs(c1 - c2) == 1;
    }

    public static int getNum(char a){
        return a - 'a' + 1;
    }
}