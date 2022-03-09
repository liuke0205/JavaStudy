package 其他;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/3/9 10:51
 */
public class Solution_微软第2题 {
    public static void main(String[] args) {
        System.out.println(func("dBacaAA", "caBdaaA"));
    }

    public static int func(String s1, String s2){
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            HashMap<Character, Integer> windows = new HashMap<>();
            for (int j = i; j < s1.length(); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                windows.put(c2, windows.getOrDefault(c2, 0) - 1);
                if (windows.getOrDefault(c1, 0) == 0){
                    windows.remove(c1);
                }
                if (windows.getOrDefault(c2, 0) == 0){
                    windows.remove(c2);
                }
                if (windows.size() == 0){
                    res++;
                }
            }
        }
        return res;
    }
}
