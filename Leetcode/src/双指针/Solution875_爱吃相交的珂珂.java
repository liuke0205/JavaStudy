package 双指针;

/**
 * @author liuke
 * @date 2022/5/7 0:06
 */
public class Solution875_爱吃相交的珂珂 {
    /**
     * 思路：
     * 1. 求出最少速度：1；最大速度：香蕉最大数；
     * 2. 求target = h 的最小速度，用二分法
     * 3. 速度是横坐标，时间是纵坐标，成反比关系
     *
     * 题解：https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw
     *
     */

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 1, min = 1;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        while (min <= max){
            int mid = (max - min) / 2 + min;
            if (fun(piles, mid) > h){
                min = mid + 1;
            }else if(fun(piles, mid) < h){
                max = mid - 1;
            }else {
                if (mid == 1 || fun(piles,mid - 1) != h){
                    return mid;
                }
                max = mid - 1;
            }
        }
        return -1;
    }

    static int fun(int[] piles, int x) {//x:吃香蕉速度 f(x):吃香蕉时间  随着x增加单调递减
        //计算出吃完所有香蕉需要花费时间
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            //遍历每一堆香蕉,如果是速度的整数倍,就能在该阶段吃完
            hour += piles[i] / x;
            if (piles[i] % x > 0) {
                hour++;
            }
        }
        return hour;
    }
}
