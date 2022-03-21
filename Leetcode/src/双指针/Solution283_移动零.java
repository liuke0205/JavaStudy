package 双指针;

/**
 * @author liuke
 * @date 2022/3/21 10:01
 */
public class Solution283_移动零 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (0 != nums[fast]){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
