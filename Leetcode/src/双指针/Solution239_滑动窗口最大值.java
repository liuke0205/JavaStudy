package 双指针;

import java.util.LinkedList;

/**
 * @author liuke
 * @date 2022/5/8 15:16
 */
public class Solution239_滑动窗口最大值 {
    /**
     * 思路：
     * 1. 计算每个窗口中的最大值，肯定需要以O（1）的时间复杂度去获取
     * 2. 那么就需要在移动窗口的时候确定出当前窗口的最大值
     * 3. 可以维护一个队列，当往窗口添加元素时，只要当前元素比队尾元素大，那就将队尾元素移除
     * 4. 保证队头元素永远是当前队列中最大的元素
     *
     * 题解：https://mp.weixin.qq.com/s/-ZQ1G4JuZCyYSCj1A3ApFw
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        MaxQueue queue = new MaxQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1){
                queue.push(nums[i]);
            }else {
                queue.push(nums[i]);
                res[idx++] = queue.max();
                queue.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    class MaxQueue{
        LinkedList<Integer> queue;
        public MaxQueue(){
            queue = new LinkedList<>();
        }
        public void push(int x){
            while (!queue.isEmpty() && queue.getLast() < x){
                queue.removeLast();
            }
            queue.addLast(x);
        }

        public void pop(int x){
            // 如果x == 当前头结点
            if (!queue.isEmpty() && x == queue.getFirst()){
                queue.removeFirst();
            }
        }

        public int max(){
            if (!queue.isEmpty()){
                return queue.getFirst();
            }
            return Integer.MIN_VALUE;
        }
    }
}
