package th12;

import java.util.Scanner;

public class Main6 {
	
	public static void main(String[] args) {
		int day_ms = 24 * 60 * 60 * 1000;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int len = str.length();
		if (len > 8) {
			str = str.substring(len-8, len);
		}
		int time = Integer.parseInt(str);
		
		int ms = time % day_ms;
		int h = (ms / (60 * 60 * 1000)) % 24;
		int m = (ms / (60 * 1000) ) % 60;
		int s = (ms / 1000) % 60;
		System.out.println(String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s));
	}
}
