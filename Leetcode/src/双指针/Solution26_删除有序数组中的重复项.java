package 双指针;

/**
 * @author liuke
 * @date 2022/3/21 9:40
 */
public class Solution26_删除有序数组中的重复项 {
    /**
     * 思路：
     * 1. 维护两个指针，左指针负责对非重复元素赋值，右指针去判断是否和左指针的元素相同
     * 2. 如果相同-> 右指针++；如果不相同，左指针移++ 然后赋值;
     * 题解：
     *
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
