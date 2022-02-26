import java.util.Arrays;

class QuickSort{
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 0};
        QuickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void QuickSort(int[] nums){
        QuickSort(nums, 0, nums.length-1);
    }
    public static void QuickSort(int[] nums, int left, int right){
        // 1. 对当前序列找出 中点：中点的左边都比中点的值小；中点的右边都比中点的值要大！
        // 2. 对于中点左边的序列 和 中点右边的序列执行上述相同的操作（递归）
        // 如何找出当前的中点？
        if (left >= right){
            return;
        }
        int index = location(nums, left, right);
        QuickSort(nums, left, index - 1);
        QuickSort(nums, index + 1, right);
    }

    private static int location(int[] nums, int left, int right) {
        int start = left;
        while (left < right){
            while (left < right && nums[right] >= nums[start]){
                right--;
            }
            while (left < right && nums[left] <= nums[start]){
                left++;
            }
            if (left < right){
                util.swap(nums, left, right);
            }
        }
        util.swap(nums, start, right);
        return right;
    }


}