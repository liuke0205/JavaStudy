package th11;

import java.util.Scanner;

public class Main7 {
	
	public static void main(String[] args) {
		int[] month = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner scanner = new Scanner(System.in);
		String dateString = scanner.nextLine();
		int y = Integer.parseInt(dateString.substring(0, 4));
		int m = Integer.parseInt(dateString.substring(4, 6));
		int d = Integer.parseInt(dateString.substring(6, 8));

		
		for (int year = y; year < 9000 ; year++) {
			if ((year % 4 == 0 && year % 100 != 0) || year% 400  == 0) {
				month[2]= 29;
			}
			int mo = 1;
			if (year == y) {
				mo = m;
			}
			for (; mo <= 12; mo++) {
				int day = 1;
				if (year == y && mo == m) {
					day = d;
				}
				for (; day <= month[mo]; day++) {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append(year).append(mo).append(day);
					
				}
			}
		}
		
	}
}
