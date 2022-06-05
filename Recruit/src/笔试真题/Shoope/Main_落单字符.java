package 笔试真题.Shoope;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * @author liuke
 * @date 2022/6/4 13:25
 */
public class Main_落单字符 {
    /**
     * https://www.nowcoder.com/questionTerminal/7d65d075833c4398bee20e3c3776e88c
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(lastUniqueChar("shopee"));
    }
    public static String lastUniqueChar (String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (map.get(str.charAt(i)) == 1){
                return str.charAt(i) + "";
            }
        }
        return "";
    }
}
