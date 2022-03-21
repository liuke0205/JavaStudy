package 笔试真题.贝壳;

import java.util.*;

public class Solution_n组数和最大 {
    /**
     * 一个长度为n的只包含小写字母的字符串s,可以把字符串划分成任意组，要求每组都是一段连续的子串，字符串的每个下标都必须要出现在其
     * 中一个组且只能出现在一组。例如:一个长度为5的字符串abcdd分成3组，共有6种可能
     *
     * 每组分值的计算方法:设分值初始为val = 0,对于每个出现在该组的小写字母，如果出现次数在该组为偶数，val+ = 1,否则val-= 1。例
     * 如:某组表示的字符串为cdd,字符c出现1次, val-= 1,字符d出现2次，val+= 1,该组分值val = 0。
     *
     * 问:可以把字符串S分成任意组，各组得分总和最大可能是多少?
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        backtracking(s, 0, new ArrayList<String>());
        System.out.println(max);
    }
    static int max = Integer.MIN_VALUE;
    public static void backtracking(String str, int idx, ArrayList<String> path){
        int cnt = 0;
        for (String s : path){
            cnt += getResult(s);
        }
        if (max > cnt){
            return;
        }
        if (idx == str.length()){
            max = Math.max(max, cnt);
            return;
        }
        for (int i = idx; i < str.length(); i++) {
            path.add(str.substring(idx, i+1));
            backtracking(str, i + 1, path);
            path.remove(path.size()- 1);
        }
    }

    private static int getResult(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 0){
                num += 1;
            }else {
                num -= 1;
            }
        }
        return num;
    }
}
