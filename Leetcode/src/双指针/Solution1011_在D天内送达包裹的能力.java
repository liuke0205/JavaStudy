package 双指针;

/**
 * @author liuke
 * @date 2022/5/7 0:44
 */
public class Solution1011_在D天内送达包裹的能力 {
    /**
     *  思路：二分法
     *  1. 横坐标是 运载量，从坐标是天数；两者是反比关系
     *  2. 最小运载量是 货物的最小值， 最大运载量是货物的所有之和；
     *
     *  题解：https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw
     */
    public int shipWithinDays(int[] weights, int days) {
        int max = 1, min = 1;
        for (int num : weights) {
            min = Math.max(min, num);
            max += num;
        }
        int left = min;
        while (min <= max){
            int mid = (max - min) / 2 + min;
            if (fun(weights, mid) > days){
                min = mid + 1;
            }else if(fun(weights, mid) < days){
                max = mid - 1;
            }else {
                if (mid == left || fun(weights,mid - 1) != days){
                    return mid;
                }
                max = mid - 1;
            }
        }
        return min;
    }

    // 运载量为x时，需要多少天
    public int fun(int[] weights, int x){
        int days = 0;
        int sum = 0;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            if(sum > x){
                days++;
                sum = weights[i];
            }else if(sum == x){
                days++;
                sum = 0;
            }
        }
        return sum > 0 ? days + 1: days;
    }
}
