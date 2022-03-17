package MyPriorityQueue;

/**
 * @author liuke
 * @date 2022/3/17 22:56
 */
public class HeapUtil {
    // 获取左子节点索引
    public static int getLeftChildIndex(int currentIndex) {
        return currentIndex * 2 + 1;
    }

    // 获取右子节点索引
    public static int getRightChildIndex(int currentIndex) {
        return currentIndex * 2 + 2;
    }

    // 获取父节点索引
    public static int getParentIndex(int currentIndex) {
        if (currentIndex == 0) {
            throw new RuntimeException("root node has no parent");
        }
        return (currentIndex - 1) / 2;
    }
}
