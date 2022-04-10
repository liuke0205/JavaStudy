package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/7 0:15
 */
public class Solution986_区间列表的交集 {
    /**
     * https://leetcode-cn.com/problems/interval-list-intersections/
     *
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length){
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right  = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right){
                res.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
