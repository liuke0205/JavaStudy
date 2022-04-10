package th11;

public class Main1 {
	
	public static void main(String[] args) {
		int cnt = 0;
		for(int i=1; i<=78120; i++) {
			if(78120 % i == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		//96
	}

}
