import java.util.Arrays;

class MergeSort{
    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 5, 10, 7};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void mergeSort(int[] nums){
        //1. 先找中点，中点：就是数组长度的中点
        //2. 对中点左边的再找中点，对中点右边的再找中点
        //3. 对当前序列的左边序列 和 右边序列 进行合并（后序遍历）【当前的左边序列和右边序列已经有序】
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int left, int right){
        // base case
        if (left >= right){
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 对左边序列和右边序列进行合并(后序遍历)
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int idx = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right){
            if (nums[i] < nums[j]){
                temp[idx++] = nums[i++];
            }else {
                temp[idx++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[idx++] = nums[i++];
        }
        while (j <= right){
            temp[idx++] = nums[j++];
        }
        for (int k = left; k <= right; k++) {
            nums[k] = temp[k - left];
        }
    }
}