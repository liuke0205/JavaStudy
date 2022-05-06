package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuke
 * @date 2022/5/6 1:01
 */
public class Solution354_俄罗斯套娃信封问题 {

}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 如果w相等,h进行降序排序，否则w进行升序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        //根据高度数组  => 转化成最长上升序列问题
        int []h = new int[envelopes.length];
        for(int i=0; i<h.length; i++){
            h[i] = envelopes[i][1];
        }
        return lengthOfLIS(h);
    }
    //最长上升序列问题求解模板
    public int lengthOfLIS(int [] nums){
        if(nums.length == 0){
            return 0;
        }
        int []dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}