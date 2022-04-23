package 笔试真题.腾讯;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liuke
 * @date 2022/4/24 0:04
 */
public class Solution_逛街 {

    /**
     * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
     * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
     *
     * 输入：
     * [5,3,8,3,2,5]
     * 输出：
     * [3,3,5,4,4,4]
     */

    public static int[] findBuilding (int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            // 比它前面元素大的个数
            left[i] = stack.size();

            while (!stack.isEmpty() && stack.peek() <= heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);
        }
        stack.clear();

        for (int i = len-1; i >= 0; i--) {
            // 比它后面元素大的个数
            right[i] = stack.size();

            while (!stack.isEmpty() && stack.peek() <= heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);
        }
        for (int i = 0; i < len; i++) {
            res[i] = left[i] + right[i] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] building = findBuilding(new int[]{5, 3, 8, 3, 2, 5});
        System.out.println(Arrays.toString(building));
    }
}
