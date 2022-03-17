package 栈和队列;

import java.util.LinkedList;

/**
 * @author liuke
 * @date 2022/3/17 21:28
 */
public class Solution239_滑动窗口的最大值 {
    public static void main(String[] args) {

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1){
                maxQueue.push(nums[i]);
            }else {
                maxQueue.push(nums[i]);
                res[idx++] = maxQueue.max();
                maxQueue.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
}

class MaxQueue{
    private LinkedList<Integer> queue;

    public MaxQueue(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        while (!queue.isEmpty() && x > queue.getLast()){
            queue.pollLast();
        }
        queue.addLast(x);
    }

    public void pop(int x){
        if (x == queue.getFirst()){
            queue.pollFirst();
        }
    }

    public int max(){
        return queue.getFirst();
    }
}