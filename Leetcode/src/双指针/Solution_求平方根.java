package 双指针;

/**
 * @author liuke
 * @date 2022/5/6 16:52
 */
public class Solution_求平方根 {
    public static void main(String[] args) {
        System.out.println(mySort(2, 1, 2, 0.0000001));
    }

    public static double mySort(double num, double low, double high, double range){
        double mid = (low + high) / 2f;
        if (num - mid * mid < 0){
            return mySort(num, low, (mid + high) / 2f, range);
        }else {
            if (num - mid * mid > range){
                return mySort(num, (low + mid) / 2f, high, range);
            }
            String str = String.format("%,6f", mid);
            return Double.parseDouble(str);
        }
    }
}
