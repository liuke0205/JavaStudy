package th13;

import java.util.Scanner;

public class Main_3质因数个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		System.out.println(fun(n));
	}
	
	public static int fun(long num) {
		if (num == 1) {
			return 0;
		}
		int cnt = 0;
		for (long i = 2; i <= num; i++) {
			if (num % i == 0 && fun2(i)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static boolean fun2(long k) {
		if (k == 2 || k == 3) {
			return true;
		}
		for (long i = 2; i < k; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}
}
