package 回溯;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/3 23:24
 */
public class Solution_N数之和 {
    static List<List<Integer>> res = new ArrayList<>();
    static int[] arr;
    static int target;
    static int n;
    public static void main(String[] args) {
        arr = new int[]{1,2,3,4,5,6,7};
        n = 3;
        target = 10;
        Arrays.sort(arr);
        backtracking(new ArrayList<Integer>(), 0);
        for (List<Integer> list : res) {
            for (Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void backtracking(ArrayList<Integer> path, int idx){
        if (path.size() == n){
            if (target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            path.add(arr[i]);
            target -= arr[i];
            backtracking(path, i+1);
            target += arr[i];
            path.remove(path.size() - 1);
        }
    }
}
