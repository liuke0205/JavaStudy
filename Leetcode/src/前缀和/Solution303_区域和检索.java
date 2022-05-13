package 前缀和;

/**
 * @author liuke
 * @date 2022/5/13 12:44
 */
public class Solution303_区域和检索 {

}

class NumArray {
    int[] pre;
    int[] nums;
    public NumArray(int[] nums) {
        pre = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pre[i] = sum;
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return pre[right] - pre[left] + nums[left];
    }
}