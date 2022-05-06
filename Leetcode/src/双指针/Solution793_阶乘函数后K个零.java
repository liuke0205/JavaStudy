package 双指针;

/**
 * @author liuke
 * @date 2022/5/6 23:36
 */
public class Solution793_阶乘函数后K个零 {
    /**
     * 思路：
     * 1，一个数的阶乘后面有多少个0，是有每个数能贡献多少个5决定的
     * 2. 找n!有k个0，其实就是找第一个阶乘为k个0的值 和 最后一个阶乘为k个0的值
     * 3. 注意数值范围用long
     *
     * 题解：https://mp.weixin.qq.com/s/qtdSnjSBZdP64YhpQIy0HA
     */
    public static void main(String[] args) {
        preimageSizeFZF(5);
    }
    public static int preimageSizeFZF(int k) {
        long left = searchLeft(k);
        if (left == -1){
            return 0;
        }
        long right = searchRight(k);
        return (int) (right - left + 1);
    }

    public static long searchLeft(long target){
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right){
            long mid = (right - left)/2 + left;
            long num = getZeros(mid);
            if (num < target){
                left = mid + 1;
            }else if (num > target){
                right = mid - 1;
            }else {
                if (mid == 0 || getZeros(mid-1) != target){
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    public static long searchRight(long target){
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right){
            long mid = (right - left)/2 + left;
            long num = getZeros(mid);
            if (num < target){
                left = mid + 1;
            }else if (num > target){
                right = mid - 1;
            }else {
                if (mid == Long.MAX_VALUE || getZeros(mid + 1) != target){
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    public static long getZeros(long n){
        long sum = 0;
        for (long i = 5; i <= n; i+=5) {
            sum += i / 5;
        }
        return sum;
    }
}
