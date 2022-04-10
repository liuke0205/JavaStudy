package 贪心;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/7 0:25
 */
public class Solution455_分发饼干 {
    /**
     * https://leetcode-cn.com/problems/assign-cookies/
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int cnt = 0;
        while (i < g.length && j < s.length){
            if (s[j] >= g[i]){
                cnt++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return cnt;
    }
}
