package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuke
 * @date 2022/4/6 23:24
 */
public class Solution452_用最少数量的箭引爆气球 {
    /**
     * https://labuladong.gitee.io/algo/3/28/98/
     *
     * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end){
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }
}
