import java.util.Arrays;

class SelectSort{
    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 5, 10, 7};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i], index = i;
            for(int j=i+1; j < len; j++){
                if(nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }
            if(index != i){
                swap(nums, index, i);
            }
        }
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}