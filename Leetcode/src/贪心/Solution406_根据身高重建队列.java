package 贪心;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author liuke
 * @date 2022/4/7 0:35
 */
public class Solution406_根据身高重建队列 {
    /**
     *
     */
    public int[][] reconstructQueue(int[][] people) {
        // 先根据身高降序排，当身高一样时按照另一个条件升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p: people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }
}
