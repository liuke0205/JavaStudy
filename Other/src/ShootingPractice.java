/**
 * @author liuke
 * @date 2022/2/26 13:35
 */
public class ShootingPractice {
    // 某人进行10次打靶，每次打靶可能的得分为0到10分，10次打靶共得 90分的可能性有多少种？
    static int res;
    public static void main(String[] args) {
        fun(0, 10);
        System.out.println(res);
    }

    public static void fun(int target, int n){
        // base case
        if (n == 0){
            if (target == 90){
                res++;
            }
            return;
        }
        for (int i = 0; i <= 10; i++) {
            fun(target + i, n-1);
        }

    }
}
