/**
 * @author liuke
 * @date 2022/2/26 17:26
 */
public class util {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
