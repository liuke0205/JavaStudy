package th11;

import java.util.Scanner;

public class Main6 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		double a = 0, b = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			if (arr[i] >= 60) {
				a++;
			}
			if (arr[i] >= 85) {
				b++;
			}
		}
		
		System.out.println(Math.round(a * 100 / n)+"%");
		System.out.println(Math.round(b * 100 / n)+"%");
	}
	
}
