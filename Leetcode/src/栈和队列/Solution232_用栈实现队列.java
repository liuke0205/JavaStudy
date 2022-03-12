package 栈和队列;

import java.util.Stack;

/**
 * @author liuke
 * @date 2022/3/11 13:34
 */
public class Solution232_用栈实现队列 {
    class MyQueue {
        Stack<Integer> in, out;
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.isEmpty() ? -1 : out.pop();
        }

        public int peek() {
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.isEmpty() ? -1 : out.pop();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
