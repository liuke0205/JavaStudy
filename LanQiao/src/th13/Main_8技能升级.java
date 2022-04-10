package th13;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_8技能升级 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		PriorityQueue<Integer> heIntegers = new PriorityQueue<>(
			(o1, o2) -> {
				return o2 - o1;
			}
		);
		while (n-->0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			for (int i = a; i > 0; i-=b) {
				heIntegers.add(i);
			}
		}
		
		int sum = 0;
		while (m-->0) {
			sum += heIntegers.poll();
		}
		System.out.println(sum);
	}
}
