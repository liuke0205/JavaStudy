package 双指针;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/2/27 12:05
 */
public class Solution_76 {
    // https://leetcode-cn.com/problems/minimum-window-substring/
    // 76 最小覆盖子串
    // 解决方案：使用滑动窗口
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        int valid = 0;
        for (Character c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, min_len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid == need.size()){
                if (right - left < min_len){
                    min_len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start + min_len);
    }
}
