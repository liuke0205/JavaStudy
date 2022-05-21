package 栈和队列;

import java.util.Stack;

/**
 * @author liuke
 * @date 2022/5/14 23:03
 *
 * 10月24日-11月22日
 */
public class Solution32_最长有效括号 {
    /**
     * 思路：
     * 1. 使用栈模拟一遍，将所有无法匹配的括号的位置标记1
     * 2. 将题目转化为 求最长连续0的个数
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] mark = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    mark[i] = 1;
                }else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            mark[stack.pop()] = 1;
        }

        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0){
                dp[i] = (mark[i] == 0)? 1 : 0;
                continue;
            }
            if (mark[i] == 0){
                dp[i] = mark[i-1] == 0 ? dp[i-1] + 1 : 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
