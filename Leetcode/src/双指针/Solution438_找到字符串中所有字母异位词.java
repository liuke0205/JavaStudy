package 双指针;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/5/8 1:11
 */
public class Solution438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int cnt = 0, min_len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(windows.get(c))){
                    cnt++;
                }
            }
            while(cnt == need.size()){
                if (right - left == p.length()){
                    res.add(left);
                }
                char ch = s.charAt(left);
                left++;
                if(need.containsKey(ch)){
                    if(need.get(ch).equals(windows.get(ch))){
                        cnt--;
                    }
                    windows.put(ch, windows.get(ch) - 1);
                }
            }
        }
        return res;
    }
}
