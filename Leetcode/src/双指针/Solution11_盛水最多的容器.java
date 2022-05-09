package 双指针;

/**
 * @author liuke
 * @date 2022/5/10 0:21
 */
public class Solution11_盛水最多的容器 {
    /**
     * 思路：
     * 1. ⽤ left 和 right 两个指针从两端向中⼼收缩，⼀边收缩⼀边计算 [left, right] 之间的矩形⾯积，取最⼤的⾯积值即是答案。
     * 2. 移动指针的时候选择当前低的那个去移动。
     *  你如果移动较低的那⼀边，那条边可能会变⾼，使得矩形的⾼度变⼤，进⽽就「有可能」使得矩形的⾯积变⼤；
     *  相反，如果你去移动较⾼的那⼀边，矩形的⾼度是⽆论如何都不会变⼤的，所以不可能使矩形的⾯积变得更⼤。
     */
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j){
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[j] > height[i]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
