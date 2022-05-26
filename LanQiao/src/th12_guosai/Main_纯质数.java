package th12_guosai;

/**
 * @author liuke
 * @date 2022/5/27 0:19
 */
public class Main_纯质数 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i <= 20210605; i++) {
            if (isZhiShu(i) && isChunZhiShu(i)){
                cnt++;
                System.out.println(i);
            }
        }
        System.out.println(cnt);
    }

    private static boolean isZhiShu(int num){
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isChunZhiShu(int num) {
        while (num > 0){
            int n = num % 10;
            num /= 10;
            if (n != 2 && n != 3 && n != 5 && n != 7){
                return false;
            }
        }
        return true;
    }
}
