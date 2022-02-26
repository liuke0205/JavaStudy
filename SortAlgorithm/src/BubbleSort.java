/**
 * @author liuke
 * @create 2021/03/25/14:03
 */
public class BubbleSort {
    static int []arr;
    public static void main(String[] args) {
        arr = new int[]{3,5,1,9,0,11,19,8,12,0};
        BubbleSort.BubbleSort(arr);
        for (int n : arr){
            System.out.println(n);
        }
    }

    public static void BubbleSort(int []arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    util.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            // 如果内层循环没有走的话，说明现在的次序已经是有序的了，就不需要再次进行循环了！
            if (!flag){
                break;
            }
        }
    }
}
