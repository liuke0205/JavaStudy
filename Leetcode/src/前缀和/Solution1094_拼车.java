package 前缀和;

/**
 * @author liuke
 * @date 2022/5/14 0:39
 */
public class Solution1094_拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 1;
        for(int[] num : trips){
            max = Math.max(num[2], max);
        }
        Difference difference = new Difference(new int[max + 1]);
        for (int[] num: trips) {
            difference.increment(num[1], num[2]-1, num[0]);
        }
        int[] result = difference.result();
        int maxCap = 0;
        for (int j : result) {
            maxCap = Math.max(maxCap, j);
        }
        return maxCap <= capacity;
    }
}
