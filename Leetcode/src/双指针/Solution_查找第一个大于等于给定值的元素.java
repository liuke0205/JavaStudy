package 双指针;

/**
 * @author liuke
 * @date 2022/5/6 20:34
 */
public class Solution_查找第一个大于等于给定值的元素 {
    public static void main(String[] args) {

    }

    public static int searchFirst(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                if (mid == 0 || nums[mid - 1] < target){
                    return mid;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
