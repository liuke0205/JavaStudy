import java.util.Arrays;

class QuickSort{
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length-1);
    }
    public static void sortColors(int[] nums, int left, int right) {
        //合法性检验
        if(left >= right){
            return;
        }
        int pos = position(nums, left, right);
        sortColors(nums, left, pos-1);
        sortColors(nums, pos + 1, right);
    }
    public static int position(int[] nums, int left, int right){
        int base = left;
        while(left < right){
            while(left < right &&   nums[right] >= nums[base]){
                right--;
            }
            while(left < right &&   nums[left] <= nums[base]){
                left++;
            }
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, base, right);
        return right;
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}