package th13;

import java.util.HashSet;
import java.util.Scanner;

public class Main_9最优清零方案 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		HashSet<Integer> set = new HashSet<>();
		int cnt = 0;
		while (set.size() < n) {
			int max_idx = getMaxIdx(arr);
			int max_val = arr[max_idx];
			if (arr[max_idx] > 0) {
				cnt += arr[max_idx];
				arr[max_idx] = 0;
				set.add(max_idx);
			}else {
				break;
			}
			
			int i = max_idx - 1;
			int loop = k - 1;
			int sum = max_val;
			
			while (i >= 0 && loop > 0 && arr[i] > 0 && sum > 0) {
				if (arr[i] == 0) {
					set.add(i);
				}
				if (sum >= arr[i]) {
					sum -= arr[i];
					arr[i] = 0;
					set.add(i);
				}else {
					arr[i] -= sum;
					sum = 0;
					break;
				}
				i--;
				loop--;
			}
			
			loop = k - 1;
			int j = max_idx + 1;
			while (j <= arr.length - 1 && loop > 0 && arr[j] > 0 && sum > 0) {
				if (arr[j] == 0) {
					set.add(j);
				}
				if (sum >= arr[j]) {
					sum -= arr[j];
					arr[j] = 0;
					set.add(j);
				}else {
					arr[j] -= sum;
					sum = 0;
				}
				j++;
				loop--;
			}
		}
		System.out.println(cnt);
	}
	
	public static int getMaxIdx(int[] arr) {
		int idx = 0, max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				idx = i;
				max = arr[i];
			}
		}
		return idx;
	}
}
