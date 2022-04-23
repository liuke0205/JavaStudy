package 面试真题.腾讯;

/**
 * @author liuke
 * @date 2022/4/23 0:51
 */
public class Solution_找峰值 {
    public static void main(String[] args) {
        int maxIdx = findMaxIdx(new int[]{1, 2, 6, 5, 4, 8, 9, 0});
        System.out.println(maxIdx);
    }

    public static int findMaxIdx(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (mid + 1 < nums.length && nums[mid] < nums[mid+1]){
                left = mid + 1;
            }
            if (mid + 1 < nums.length && nums[mid] > nums[mid+1]){
                right = mid;
            }
        }
        return left;
    }
}
