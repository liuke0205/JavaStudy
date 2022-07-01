package 面试真题.蔚来;

/**
 * @author liuke
 * @date 2022/7/1 23:57
 */
public class 第K大的数_快排 {
    /*
    https://leetcode.cn/problems/kth-largest-element-in-an-array/
     */
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int loc = location(nums, left, right);
            if(loc > k){
                right = loc -1;
            }else if(loc < k){
                left = loc + 1;
            }else{
                return nums[loc];
            }
        }
        return -1;
    }
    public int location(int[] nums, int left, int right){
        int base = left;
        while(left < right){
            while(left < right && nums[right] >= nums[base]){
                right--;
            }
            while(left < right && nums[left] <= nums[base]){
                left++;
            }
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, base, left);
        return right;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}