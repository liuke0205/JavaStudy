package th13;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4_数位排序 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<>(
			(o1, o2)->{
				if(sum(o1) == sum(o2)) {
					return o1 - o2;
				}
				return sum(o1) - sum(o2);
			}
		);
		for (int i = 1; i <= n; i++) {
			heap.add(i);
		}
		int res = 0;
		while (m-- > 0) {
			res = heap.poll();
		}
		System.out.println(res);
	}
	
	public static int sum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
		
	}

}
