package th11;

public class Main3 {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[100][100];
		
		int i = 0, j = 0;
		
		int idx = 1;
		arr[i][j] = idx++;
		while (i < 50 && j < 50) {
			j++;
			arr[i][j] = idx++;
			int sum = i + j;
			while (j-1 >=0) {
				j--;
				i = sum - j;
				arr[i][j] = idx++;
			}
			i++;
			arr[i][j] = idx++;
			sum = i + j;
			while (i-1 >=0) {
				i--;
				j = sum - i;
				arr[i][j] = idx++;
			}
			                                         
		}
		
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[0].length; k2++) {
				System.out.print(arr[k][k2] + " ");
			}
			System.out.println();
		}
		System.out.println(arr[19][19]);
		// 761
	}
	
	

}
