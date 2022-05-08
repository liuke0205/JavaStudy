package 双指针;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/5/8 16:12
 */
public class Solution870_优势洗牌 {
    /**
     * 思路：
     * 1. 对于num1来说，如果最大值比nums2的最大值大那就比，否则给他一个最小值去和他比
     * 2. 维护一个class去记录nums2元素和之前的下标，然后对nums2按照元素值进行排序
     * 3. nums1也进行排序
     *
     * 题解：https://mp.weixin.qq.com/s/Rxx3BGxRLe_FZHqNS2ILsg
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Node[] nodes = new Node[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            nodes[i] = new Node(nums2[i], i);
        }
        Arrays.sort(nodes,(a, b)-> {
            return a.num - b.num;
        });
        Arrays.sort(nums1);
        int i = 0, j = nums1.length - 1;
        for (int k = nums2.length - 1; k >= 0; k--) {
            if (nums1[j] > nodes[k].num){
                res[nodes[k].idx] = nums1[j--];
            }else {
                res[nodes[k].idx] = nums1[i++];
            }
        }
        return res;
    }

    class Node{
        int num, idx;
        public Node(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
}
