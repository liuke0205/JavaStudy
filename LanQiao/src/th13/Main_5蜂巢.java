package th13;

import java.util.Scanner;

public class Main_5蜂巢 {
	
	
	public static void main(String[] args) {
		int[] arr = new int[6];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(Math.max(arr[1], arr[2]) + Math.max(arr[4], arr[5]) - 1);
	}
}
