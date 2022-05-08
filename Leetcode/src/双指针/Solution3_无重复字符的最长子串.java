package 双指针;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuke
 * @date 2022/3/31 22:41
 */
public class Solution3_无重复字符的最长子串 {
    /**
     * 思路：
     * 1. 双指针，i负责左窗口，j负责右窗口
     * 2. 维护一个set集合存当前窗口中的所有元素
     * 3. 当右指针对应的元素在窗口中时，移动左指针并更新set集合
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windows = new HashSet<>();
        int max = 1;
        int i = 0, j = 0;
        while (j < s.length()){
            char c = s.charAt(j++);
            while (windows.contains(c)){
                char d = s.charAt(i++);
                windows.remove(d);
            }
            windows.add(c);
            max = Math.max(max, windows.size());
        }
        return max;
    }
}
