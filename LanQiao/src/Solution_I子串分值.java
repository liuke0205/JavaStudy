import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/4 1:18
 */
public class Solution_I子串分值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int cnt  = 0;
        for (int k = 0; k < s.length(); k++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0, j = k;
            for (int l = i; l <= j; l++) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
            }
            int num = 0;
            for (Map.Entry<Character, Integer> entry: map.entrySet()){
                if (entry.getValue() == 1){
                    num++;
                }
            }
            cnt += num;
            while (++j < s.length()){
                char c1 = s.charAt(i++);
                char c2 = s.charAt(j);
                map.put(c1, map.getOrDefault(c1, 0) - 1);
                map.put(c1, map.getOrDefault(c2, 0) + 1);
                if (map.getOrDefault(c1, 0) == 1){
                    cnt++;
                }else if (map.getOrDefault(c1, 0) == 0){
                    cnt--;
                }
                if (map.getOrDefault(c2, 0) == 1){
                    cnt++;
                }else if (map.getOrDefault(c2, 0) == 2){
                    cnt--;
                }
            }
            map.clear();
        }
        System.out.println(cnt);
    }
}
