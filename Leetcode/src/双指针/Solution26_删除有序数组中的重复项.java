package 双指针;

/**
 * @author liuke
 * @date 2022/3/21 9:40
 */
public class Solution26_删除有序数组中的重复项 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
