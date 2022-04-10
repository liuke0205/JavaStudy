package th13;

public class Main_1排序字母 {
	public static void main(String[] args) {
		int[] arr = new int[26];
		String string = "WHERETHEREISAWILLTHEREISAWAY";
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++) {
			arr[string.charAt(i) - 'A']++;
		}
		for (int i = 0; i < arr.length; i++) {
			int cnt = arr[i];
			while (cnt-->0) {
				System.out.print((char)(i + 'A'));
			}
		}
	}
}
