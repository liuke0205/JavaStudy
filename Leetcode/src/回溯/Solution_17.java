package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/3/2 21:13
 */
public class Solution_17 {
    List<String> res;
    String []letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if("".equals(digits)){
            return res;
        }
        helper(digits, new StringBuffer(""), 0);
        return res;
    }
    public void helper(String digits, StringBuffer sb, int index){
        if(digits.length() == index){
            res.add(sb.toString());
            return;
        }
        Character c = digits.charAt(index);
        String temp = letters[c - '0'];
        for(int i=0; i<temp.length(); i++){
            helper(digits, sb.append(temp.charAt(i)), index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}