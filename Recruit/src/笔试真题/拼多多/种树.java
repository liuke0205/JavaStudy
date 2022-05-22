package 笔试真题.拼多多;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 1:13
 */
public class 种树 {
    /**
     * https://www.nowcoder.com/questionTerminal/52f25c8a8d414f8f8fe46d4e62ef732c
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            len += arr[i];
            map.put(i + 1, arr[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();

        if (dfs(map, len, res)){
            for (Integer num : res){
                System.out.print(num + " ");
            }
            return;
        }
        System.out.println("-");
    }

    public static boolean dfs(HashMap<Integer, Integer> map, int idx, ArrayList<Integer> res){
        if (idx == 0){
            return true;
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0 && (res.isEmpty() || !key.equals(res.get(res.size() - 1)))){
                map.put(key, map.get(key) - 1);
                res.add(key);
                if (dfs(map, idx - 1, res)){
                    return true;
                }
                res.remove(res.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
        return false;
    }
}
