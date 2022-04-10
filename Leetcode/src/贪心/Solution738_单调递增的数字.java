package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:37
 */
public class Solution738_单调递增的数字 {
    /**
     * https://leetcode-cn.com/problems/monotone-increasing-digits/
     * <p>
     * 贪心策略：从后往前遍历，遇到前面比后面大的数，就将前面的--，后面的置为9
     */
    public int monotoneIncreasingDigits(int n) {
        if (n == 0) return 0;
        char[] chars = Integer.toString(n).toCharArray();
        int start = Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1]--;
                start = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' && i == 0){
                continue;//防止出现09这样的情况
            }
            if (i >= start) {
                res.append('9');
            } else {
                res.append(chars[i]);
            }
        }
        return Integer.parseInt(res.toString());
    }
}
