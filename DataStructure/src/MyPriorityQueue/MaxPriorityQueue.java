package MyPriorityQueue;

import java.util.ArrayList;

/**
 * @author liuke
 * @date 2022/3/17 21:53
 * 参考：https://juejin.cn/post/7048788221416701983
 */
class MaxPriorityQueue<T extends Comparable> {
    private ArrayList<T> array;

    public MaxPriorityQueue(){
        array = new ArrayList<>();
    }

    /**
     * 往大顶堆中添加一个元素
     * @param val
     */
    public void push(T val){
        int lastIndex = size();
        array.add(lastIndex, val);
        // 上浮
        siftUp(lastIndex);
    }

    /**
     * 删除并返回大顶堆的堆顶（当前序列的最大值）
     * @return max
     */
    public T pop(){
        // 根节点为最大值
        T top = array.get(0);

        // 最后一个节点删除并移动至堆顶
        int lastIndex = size() - 1;
        T lastNode = array.get(lastIndex);
        array.remove(lastIndex);
        array.set(0, lastNode);

        // 节点下沉
        siftDown(0);

        // 返回最大值
        return top;
    }

    /**
     * 返回优先队列元素的个数
     * @return
     */
    public int size(){
        return array.size();
    }

    private void siftUp(int curIndex) {
        while (curIndex != 0){
            // 当前节点
            T currentValue = array.get(curIndex);
            // 父索引
            int parentIndex = HeapUtil.getParentIndex(curIndex);
            // 父节点
            T parentValue = array.get(parentIndex);
            // 当前节点小于父节点则退出循环
            if (currentValue.compareTo(parentValue) < 0) {
                break;
            }
            // 当前节点大于等于父节点则交换位置
            array.set(parentIndex, currentValue);
            array.set(curIndex, parentValue);
            curIndex = parentIndex;
        }
    }

    private void siftDown(int curIndex) {
        // 当前节点没有左子节点则无需下沉
        while (HeapUtil.getLeftChildIndex(curIndex) < size()) {
            // 当前节点
            T currentValue = array.get(curIndex);
            // 左子索引
            int leftChildIndex = HeapUtil.getLeftChildIndex(curIndex);
            // 左子节点
            T leftChildValue = array.get(leftChildIndex);
            // 右子索引
            Integer rightChildIndex = null;
            // 右子节点
            T rightChildValue = null;
            // 右子节点是否存在
            if (HeapUtil.getRightChildIndex(curIndex) < size()) {
                rightChildIndex = HeapUtil.getRightChildIndex(curIndex);
                rightChildValue = array.get(rightChildIndex);
            }
            // 右子节点存在
            if (null != rightChildIndex) {
                // 找出左右子节点较大节点
                int biggerIndex = rightChildIndex;
                if (leftChildValue.compareTo(rightChildValue) > 0) {
                    biggerIndex = leftChildIndex;
                }
                // 较大节点小于当前节点则退出循环
                T biggerValue = array.get(biggerIndex);
                if (biggerValue.compareTo(currentValue) < 0) {
                    break;
                }
                // 较大节点大于等于当前节点则交换位置
                array.set(curIndex, biggerValue);
                array.set(biggerIndex, currentValue);
                curIndex = biggerIndex;
            }
            // 右子节点不存在
            else {
                // 左子节点小于当前节点则退出循环
                if (leftChildValue.compareTo(currentValue) < 0) {
                    break;
                }
                // 左子节点大于等于当前节点则交换位置
                array.set(curIndex, leftChildValue);
                array.set(leftChildIndex, currentValue);
                curIndex = leftChildIndex;
            }
        }
    }

    private boolean less(int curIndex, int parentIndex) {
        return array.get(curIndex).compareTo(array.get(parentIndex)) < 0;
    }

    private void swap(int curIndex, int parentIndex) {

    }

    @Override
    public String toString() {
        return array.toString();
    }
}