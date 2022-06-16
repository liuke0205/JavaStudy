package 笔试真题.华为;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main_字符集合 {
    /**
     * https://www.nowcoder.com/questionTerminal/784efd40ed8e465a84821c8f3970b7b5
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strs = scanner.nextLine();
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < strs.length(); i++) {
                char c = strs.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, i);
                }
            }
            for (Character key : map.keySet()) {
                System.out.print(key);
            }
            System.out.println();
        }
    }
}
