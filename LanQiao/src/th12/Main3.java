package th12;

import java.util.HashSet;
import java.util.Set;

public class Main3 {
	
	public static void main(String[] args) {
		Set<Node> set = new HashSet<>();
		for (int i1 = 0; i1 < 20; i1++) {
			for (int i2 = 0; i2 < 20; i2++) {
				for (int j1 = 0; j1 < 21; j1++) {
					for (int j2 = 0; j2 < 21; j2++) {
						if (i1 == i2) {
							continue;
						}
						double num = (j2 - j1) * 1.0 / (i2 - i1) * 1.0;
						double b = j2 - num * i2;
						System.out.println(num);
						Node node = new Node(num, b);
						set.add(node);
					}
				}
			}
		}
		System.out.println(set.size() / 2 + 20);
	}
}

class Node{
	double a;
	double b;
	
	public Node(double a, double b) {
		this.a = a;
		this.b = b;
	}
}
