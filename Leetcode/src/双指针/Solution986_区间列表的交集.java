package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuke
 * @date 2022/5/10 0:48
 */
public class Solution986_区间列表的交集 {
    /**
     * 思路：
     * 1. 维护两个指针，分别指向两个数组
     * 2. 比较当前两个指针指向的区间有无交集
     * 3. 尾结点小的指针++
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length){
            int i_start = firstList[i][0];
            int i_end = firstList[i][1];
            int j_start = secondList[j][0];
            int j_end = secondList[j][1];
            int min_right = Math.min(i_end, j_end);
            int max_left = Math.max(i_start, j_start);
            if (min_right >= max_left){
                res.add(new int[]{max_left, min_right});
            }
            if (i_end < j_end){
                i++;
            }else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
