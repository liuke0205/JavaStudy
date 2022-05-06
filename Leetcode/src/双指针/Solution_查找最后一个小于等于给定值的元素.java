package 双指针;

/**
 * @author liuke
 * @date 2022/5/6 20:34
 */
public class Solution_查找最后一个小于等于给定值的元素 {
    public static void main(String[] args) {

    }

    public static int searchLast(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            }else {
                if (mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
