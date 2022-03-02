package 回溯;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:53
 */
public class Solution_131 {

    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int idx){
        if (idx >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (checkPalindrome(s, idx, i)){
                path.add(s.substring(idx, i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    //根据起始下标判断是否是回文串
    public static boolean checkPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
