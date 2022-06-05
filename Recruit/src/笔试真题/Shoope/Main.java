package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/5 20:15
 */
public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i < 1000; i++) {
            if (fun(i)){
                cnt++;
                System.out.println(i);
            }
        }
        System.out.println(cnt);
    }

    public static boolean fun(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum % 10 == 0;
    }
}
