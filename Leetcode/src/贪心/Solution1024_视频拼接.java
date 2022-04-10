package 贪心;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/7 0:17
 */
public class Solution1024_视频拼接 {
    /**
     * https://leetcode-cn.com/problems/video-stitching/
     *
     * 贪心策略：先按照起点从小到大去排序，当起点一样的时候，按照终点从大到小排序
     *  在当前区间时，选择起点比当前区间终点小的那些区间中找出 终点最大的当做下一个区间的终点
     */
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2)->{
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int cnt = 0, idx = 0, curEnd = 0, nextEnd = 0;
        while (idx < clips.length && clips[idx][0] <= curEnd){
            // 在第cnt个区间中贪心找出下一个区间
            while (idx < clips.length && clips[idx][0] <= curEnd){
                nextEnd = Math.max(nextEnd, clips[idx][1]);
                idx++;
            }
            cnt++;
            curEnd = nextEnd;
            if (curEnd >= time){
                return cnt;
            }
        }
        return -1;
    }
}
