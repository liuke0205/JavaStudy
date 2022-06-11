package guosai;

/**
 * @author liuke
 * @date 2022/6/11 21:28
 */
public class Main_求值 {
    /**
     * 根据“约数个数定理” 100=2* 2* 5 *5 最小为：2^(5-1)*3^(5-1)*5^(2-1)*7^(2-1)
     * n = A^a + B^b n的约数个数为：(a+1)*(b+1)  A、B是质数
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 10; i < Integer.MAX_VALUE; i++) {
            if (cntYueShu(i) == 100){
                System.out.println(i);
                break;
            }
        }
    }

    public static int cntYueShu(int n){
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
