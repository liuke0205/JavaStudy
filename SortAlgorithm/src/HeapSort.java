import java.util.Arrays;

class HeapSort{
    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 5, 10, 7};
        heapSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
    public static void heapSort(int[] tree, int n){
        buildTree(tree, n);
        for (int i = n-1; i >=0 ; i--) {
            swap(tree, i, 0);
            heapify(tree, i, 0);
        }
    }
    public static void buildTree(int[] tree, int n){
        int last_node = n - 1;
        for (int i = (last_node - 1) / 2; i >=0 ; i--) {
            heapify(tree, n, i);
        }
    }
    public static void heapify(int[] tree, int n, int i){
        int ch1 = 2 * i + 1, ch2 = 2 * i + 2;
        int max = i;
        if(ch1 < n && tree[ch1] > tree[max]){
            max = ch1;
        }
        if(ch2 < n && tree[ch2] > tree[max]){
            max = ch2;
        }
        if(max != i){
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}