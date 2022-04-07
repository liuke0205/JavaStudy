package 贪心;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/6 23:38
 */
public class Solution253_会议室II {
    /**
     * 给你输入若干形如 [begin, end] 的区间，代表若干会议的开始时间和结束时间，请你计算至少需要申请多少间会议室。
     * 如果会议之间的时间有重叠，那就得额外申请会议室来开会，想求至少需要多少间会议室，就是让你计算同一时刻最多有多少会议在同时进行。
     * 如果把每个会议的起始时间看做一个线段区间，那么题目就是让你求最多有几个重叠区间
     *
     * https://labuladong.gitee.io/algo/3/28/99/
     */

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int i = minMeetingRooms(ints);
        System.out.println(i);
    }
    static int minMeetingRooms(int[][] meetings){
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int i = 0, j = 0;
        int cnt = 0, max = 0;
        while (i < n && j < n){
            if (begin[i] < end[j]){
                cnt++;
                i++;
            }else {
                cnt--;
                j++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
