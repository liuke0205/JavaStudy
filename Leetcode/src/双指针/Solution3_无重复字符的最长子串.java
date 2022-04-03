package 双指针;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuke
 * @date 2022/3/31 22:41
 */
public class Solution3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 1;
        int i = 0, j = 0;
        while (j < s.length()){
            char c = s.charAt(j++);
            while (set.contains(c)){
                set.remove(s.charAt(i++));
            }
            set.add(c);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
