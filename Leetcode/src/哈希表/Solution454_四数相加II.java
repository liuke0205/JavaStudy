package 哈希表;

import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/3/27 23:50
 */
public class Solution454_四数相加II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 =  new HashMap<>();
        HashMap<Integer, Integer> map2 =  new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                cnt += map1.getOrDefault(-sum, 0);
                map2.put(sum, map2.getOrDefault(sum, 0) + 1);
            }
        }
        return cnt;
    }
}
