package 贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/7 0:36
 */
public class Solution763_划分字母区间 {
    /**
     * https://leetcode-cn.com/problems/partition-labels/
     */
    public static List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            int idx = map.get(s.charAt(j));
            right = Math.max(idx, right);
            if (right == j){
                res.add(right - left + 1);
                left = j + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
}
