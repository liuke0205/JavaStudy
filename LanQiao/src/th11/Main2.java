package th11;

public class Main2 {
	
	public static void main(String[] args) {
		int[] month = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int flag = 6;
		int cnt = 0;
		for (int year = 2000; year <= 2020 ; year++) {
			if ((year % 4 == 0 && year % 100 != 0) || year% 400  == 0) {
				month[2]= 29;
			}else {
				month[2] = 28;
			}

			for (int mo = 1; mo <= 12; mo++) {
				int day = 1;
				for (; day <= month[mo]; day++) {
					cnt++;
					if (flag == 8) {
						flag = 1;
					}
					
					if (day == 1 || flag == 1) {
						cnt++;
					}
					flag++;
					if (year == 2020 && mo == 10 && day == 1) {
						System.out.println(cnt);
						break;
					}
				}
			}
		}		
	}
}
