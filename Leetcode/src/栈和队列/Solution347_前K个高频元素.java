package 栈和队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/17 14:49
 */
public class Solution347_前K个高频元素 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1.统计各个元素的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 2.对元素根据出现的频率进行排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(map::get)
        );
        for (Integer key : map.keySet()){
            heap.add(key);
            if (heap.size() > k){
                heap.poll();
            }
        }
        // 3.找出频率最高的k个元素
        int[] res = new int[k];
        int idx = 0;
        while (!heap.isEmpty()){
            res[idx++] = heap.poll();
        }
        return res;
    }
}
