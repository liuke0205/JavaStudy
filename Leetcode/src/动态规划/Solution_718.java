package 动态规划;

/**
 * @author liuke
 * @date 2022/2/28 22:43
 */
public class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for(int i=0; i < len1; i++){
            for(int j=0; j < len2; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = (nums1[i] == nums2[j]) ? 1 : 0;
                }else{
                    if(nums1[i] == nums2[j]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
