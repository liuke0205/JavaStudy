package 贪心;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/10 18:06
 */
public class Solution252_会议室 {
    /**
     * https://www.lintcode.com/problem/920/description
     */

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()){
            return true;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            int cur_start = intervals.get(i).start;
            if (cur_start < end){
                return false;
            }else {
                end = intervals.get(i).end;
            }
        }
        return true;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}