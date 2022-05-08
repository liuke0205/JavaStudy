package 双指针;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/5/8 0:46
 */
public class Solution567_字符串的排列 {
    /**
     * 思路：
     * 1. 滑动窗口
     * 2. 左右指针维护当前窗口，使用两个map去维护每个元素的个数
     * 3. 当一个元素个数在两个map中相同时，维护一个num++
     * 4. 当num == s1字符串元素的个数时，缩小窗口
     * 5. 求满足条件的最小窗口 == s1的长度 -> true
     */
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int num = 0, min_len = Integer.MAX_VALUE;

        int i = 0, j = 0;
        while (j < s2.length()){
            char c1 = s2.charAt(j++);
            if (map1.containsKey(c1)){
                map2.put(c1, map2.getOrDefault(c1, 0) + 1);
                if (map2.get(c1).equals(map1.get(c1))){
                    num++;
                }
            }

            while (num == map1.size()){
                if(j - i == s1.length()){
                    return true;
                }
                char c2 = s2.charAt(i++);
                if (map1.containsKey(c2)){
                    if (map1.get(c2).equals(map2.get(c2))){
                        num--;
                    }
                    map2.put(c2, map2.getOrDefault(c2, 0) - 1);
                }
            }
        }
        return false;
    }
}
