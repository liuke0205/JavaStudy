package 双指针;

/**
 * @author liuke
 * @date 2022/3/20 18:43
 */
public class Solution27_移除元素 {
    public static void main(String[] args) {

    }
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
