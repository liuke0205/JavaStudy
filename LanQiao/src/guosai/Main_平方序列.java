package guosai;

/**
 * @author liuke
 * @date 2022/6/11 20:47
 */
public class Main_平方序列 {
    /**
     * 反思：看清题意，让输出什么！！审题；明确出口条件；
     */
    static long x, y;
    public static void main(String[] args) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (check(i)){
                System.out.println(x + y);
                break;
            }
        }
    }

    public static boolean check(int n){
        long xx = 2019 * 2019 + n;
        long yy = 2019 * 2019 + 2L * n;
        x = (long) Math.sqrt(xx);
        y = (long) Math.sqrt(yy);
        if (x * x == xx && y * y == yy){
            return true;
        }
        return false;
    }
}
