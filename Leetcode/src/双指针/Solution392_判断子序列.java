package 双指针;

/**
 * @author liuke
 * @date 2022/5/6 1:04
 */
public class Solution392_判断子序列 {

}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(int j=0; j<t.length(); j++){
            if(i >= s.length()){
                return true;
            }
            if(t.charAt(j) == s.charAt(i)){
                i++;
            }
        }
        return i == s.length();
    }
}