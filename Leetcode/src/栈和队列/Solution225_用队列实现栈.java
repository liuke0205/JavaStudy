package 栈和队列;

import javax.print.DocFlavor;
import java.util.LinkedList;

/**
 * @author liuke
 * @date 2022/3/11 15:31
 */
public class Solution225_用队列实现栈 {
    class MyStack {
        LinkedList<Integer> in, out;
        public MyStack() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void push(int x) {
            in.offer(x);
            while (!out.isEmpty()){
                in.offer(out.poll());
            }
            LinkedList tmp = in;
            in = out;
            out = tmp;
        }

        public int pop() {
            return out.poll();
        }

        public int top() {
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
