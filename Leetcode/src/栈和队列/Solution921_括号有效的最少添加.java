package 栈和队列;

/**
 * @author liuke
 * @date 2022/5/14 22:34
 */
public class Solution921_括号有效的最少添加 {
    /**
     * 以左括号为基准，通过维护对右括号的需求数 right，来计算最⼩的插⼊次数。
     */
    public int minAddToMakeValid(String s) {
        // res 记录插⼊次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 对右括号的需求 + 1
                need++;
            }
            if (s.charAt(i) == ')') {
                // 对右括号的需求 - 1
                need--;
                if (need == -1) {
                    need = 0;
                    // 需插⼊⼀个左括号
                    res++;
                }
            }
        }
        return need + res;
    }
}
