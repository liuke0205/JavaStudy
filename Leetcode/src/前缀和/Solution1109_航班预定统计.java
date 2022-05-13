package 前缀和;

/**
 * @author liuke
 * @date 2022/5/14 0:30
 */
public class Solution1109_航班预定统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Diff diff = new Diff(nums);
        for (int i = 0; i < bookings.length; i++) {
            diff.incr(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }
        return diff.getNums();
    }
}


class Diff{
    int[] diff, nums;
    public Diff(int[] nums){
        this.nums = nums;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void incr(int left, int right, int val){
        diff[left] += val;
        if (right + 1 < diff.length){
            diff[right + 1] -= val;
        }
    }

    public int[] getNums(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i-1];
        }
        return res;
    }
}
