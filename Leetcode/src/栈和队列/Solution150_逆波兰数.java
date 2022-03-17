package 栈和队列;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author liuke
 * @date 2022/3/11 16:59
 */
public class Solution150_逆波兰数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch (str){
                case "+": stack.push(stack.pop() + stack.pop());break;
                case "-": stack.push(-(stack.pop()-stack.pop()));break;
                case "*": stack.push(stack.pop() * stack.pop());break;
                case "/":
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                    break;
                default: stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}