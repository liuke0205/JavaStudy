import java.util.Arrays;

class HeapSort{
    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 5, 10, 7};
        heapSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
    /*
    1. 先把数组构造成一个大顶堆（父亲节点的元素值都比孩子节点的大），然后把堆顶和 当前无序数组的最后一个元素进行交换（保证将当前无序数组的最大值放到正确的位置上）.
    2. 把当前无序数组再次进行堆重建，然后重复上述过程.
     */
    public static void heapSort(int[] tree, int n){
        //建堆：保证堆顶元素是最大的，每个元素的左右孩子都比他的值要小
        for (int i = n/2; i >= 0; i--) {
            heapAdjust(tree, i, n);
        }

        for (int i = n-1; i > 0; i--) {
            // 将堆顶元素 和 最后一个无序元素 进行交换 -> 将无序序列的最大值放到正确的位置
            util.swap(tree, 0, i);
            // 对 0 ~ i-1元素进行堆重建
            heapAdjust(tree, 0, i-1);
        }
    }

    // 调整当前堆 -> 使他变成一个大顶堆（每个节点的值都比他的左右孩子要大）
    private static void heapAdjust(int[] tree, int i, int j) {
        // 从上向下调整堆
        int left = 2 * i + 1, right = 2 * i + 2;
        int max_idx = i;
        if (left < j && tree[left] > tree[max_idx]){
            max_idx = left;
        }
        if (right < j && tree[right] > tree[max_idx]){
            max_idx = right;
        }
        if (max_idx != i){
            util.swap(tree, i, max_idx);
            heapAdjust(tree, max_idx, j);
        }
    }
}