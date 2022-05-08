package 双指针;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/5/8 0:43
 */
public class Solution76_最小覆盖子串 {
    /**
     * 思路：
     * 1. 双指针维护一个滑动窗口
     * 2. 维护两个HashMap，分别存储每个字符串中每个元素的个数
     * 3. 当第一个hashmap中的元素满足条件 就缩小窗口
     * 4. 记录最小的长度 和 左指针
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int num = 0;
        int i = 0, j = 0;
        int min_len = Integer.MAX_VALUE, left = 0;
        while (j < s.length()){
            char c = s.charAt(j++);
            if (need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))){
                    num++;
                }
            }

            // 满足条件，收缩窗口
            while (num == need.size()){
                if (j - i < min_len){
                    left = i;
                    min_len = j - i;
                }

                char d = s.charAt(i++);
                if (need.containsKey(d)){
                    if (windows.get(d).equals(need.get(d))){
                        num--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(left, left +min_len);
    }
}
