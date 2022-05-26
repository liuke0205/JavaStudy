package th11_guosai;

/**
 * @author liuke
 * @date 2022/5/26 13:33
 */
public class A_合数个数 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i <= 2020; i++) {
            if (isHeShu(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isHeShu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return true;
            }
        }
        return false;
    }
}
