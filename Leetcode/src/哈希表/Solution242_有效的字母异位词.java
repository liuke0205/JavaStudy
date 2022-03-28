package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/3/27 23:22
 */
public class Solution242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
