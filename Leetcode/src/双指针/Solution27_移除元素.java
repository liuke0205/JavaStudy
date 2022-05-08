package 双指针;

/**
 * @author liuke
 * @date 2022/3/20 18:43
 */
public class Solution27_移除元素 {
    /**
     * 思路：
     * 1. 维护两个指针，左指针负责赋值，右指针负责和val比较是否一样
     * 2. 如果相等，那么右指针++；否则，给左指针位置赋值，然后左指针++；
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
