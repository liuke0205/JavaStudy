/**
 * @author liuke
 * @date 2022/4/9 23:40
 */
public class SegmentTree {
    /**
     * 线段树
     *
     * https://www.bilibili.com/video/BV1cb411t7AM?from=search&seid=13734048596551431654&spm_id_from=333.337.0.0
     */
    private int[] arr;
    private int[] tree;
    private int size;
    public SegmentTree(int[] arr){
        this.arr = arr;
        this.size = arr.length;
        tree = new int[4 * size];
        build_tree(0, 0, size-1);
    }

    private void build_tree(int node, int start, int end) {
        if (start == end){
            tree[node] = arr[start];
            return;
        }
        int mid = (end - start) / 2 + start;
        int left_node = node * 2 + 1;
        int right_node = node * 2 + 2;
        build_tree(left_node, start, mid);
        build_tree(right_node, mid + 1, end);
        tree[node] = tree[left_node] + tree[right_node];
    }

    private void update_tree(int node, int start, int end, int idx, int val){
        if (start == end){
            tree[node] = val;
            arr[idx] = val;
            return;
        }
        int mid = (end - start) / 2 + start;
        int left_node = node * 2 + 1;
        int right_node = node * 2 + 2;
        if (idx >= start && idx <= mid){
            update_tree(left_node, start, mid, idx, val);
        }else {
            update_tree(right_node, mid+1, end, idx, val);
        }
        tree[node] = tree[left_node] + tree[right_node];
    }

    private int query_tree(int node, int start, int end, int L, int R){
        if (L > end || R < start){
            return 0;
        }else if (L <= start && R >= end){
            return tree[node];
        }
        int mid = (end - start) / 2 + start;
        int left_node = node * 2 + 1;
        int right_node = node * 2 + 2;
        return query_tree(left_node, start, mid, L, R) + query_tree(right_node, mid+1, end, L, R);
    }

    public int query_tree(int L, int R){
        return query_tree(0,0, size - 1, L, R);
    }

    public void update_tree(int idx, int val){
        update_tree(0, 0, size - 1, idx, val);
    }


    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11});
//        for (int i = 0; i < 15; i++) {
//            System.out.println(segmentTree.tree[i]);
//        }
//
//        segmentTree.update_tree(4, 6);
//        for (int i = 0; i < 15; i++) {
//            System.out.println(segmentTree.tree[i]);
//        }

        System.out.print(segmentTree.query_tree(2, 5));
    }
}
