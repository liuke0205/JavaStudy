package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuke
 * @date 2022/4/7 0:30
 */
public class Solution1005_K次取反后最大化的数组和 {
    /**
     * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int idx = 0;
        while (K > 0 && idx < A.length && A[idx] < 0){
            K--;
            A[idx] *= -1;
            idx++;
        }
        Arrays.sort(A);
        while (K-->0){
            A[0] *= -1;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
