package 双指针;

/**
 * @author liuke
 * @date 2022/5/5 23:49
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);
        return res;
    }

    public int searchLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                if ((mid == 0) || (nums[mid - 1] != target)) return mid;
                else right = mid - 1;
            }
        }
        return -1;
    }
    public int searchRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                if ((mid == nums.length - 1) || (nums[mid + 1] != target)) return mid;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
