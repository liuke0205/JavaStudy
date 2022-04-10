package th13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main_7重新排序 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int[] prex = new int[n];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			sum += arr[i];
			prex[i] = sum;
		}
		
		int T = scanner.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Node> heap = new PriorityQueue<>(
			(o1, o2)->{
				return o2.cnt - o1.cnt;
			}
		);
		int sum1 = 0;
		while (T-->0) {
			int left = scanner.nextInt() - 1;
			int right = scanner.nextInt() - 1;
			sum1 += prex[right] - prex[left] + arr[left];
			for (int i = left; i <= right; i++) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		
		for (Integer keyInteger : map.keySet()) {
			Integer vaInteger = map.get(keyInteger);
			Node node = new Node(keyInteger, vaInteger);
			heap.add(node);
		}
		
		Arrays.sort(arr);
		int idx = arr.length - 1;
		int sum2 = 0;
		while (!heap.isEmpty()) {
			Node node = heap.poll();
			sum2 += node.cnt * arr[idx--];
		}
		System.out.println(sum2 - sum1);
	}
}

class Node{
	int num;
	int cnt;
	public Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}
