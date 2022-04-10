package th12;

import java.util.Arrays;

public class Main2 {
	
	static int[] arr;
	public static void main(String[] args) {
		arr = new int[10];
		Arrays.fill(arr, 2021);
		int i = 1;
		while (i < Integer.MAX_VALUE) {
			if (fun(i)) {
				i++;
			}else {
				break;
			}
		}
		System.out.println(i);
	}
	
	public static boolean fun(int n){
		while (n > 0) {
			int num = n % 10;
			if (arr[num] <= 0) {
				return false;
			}
			arr[num]-=1;
			n /= 10;
		}
		return true;
	}

}
