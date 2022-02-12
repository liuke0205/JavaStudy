package Sort;

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
        for(int i=0; i<len-1; i++){
            for(int j= 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
