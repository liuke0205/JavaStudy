package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:53
 */
public class Solution_93 {

    List<String> res, path;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int idx){
        if (path.size() == 4 && idx >= s.length()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append(".");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isValid(s, idx, i)){
                path.add(s.substring(idx, i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    //根据起始下标判断是否是回文串
    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
