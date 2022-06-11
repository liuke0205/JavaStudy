package guosai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/11 19:31
 */
public class Main_答疑 {
    // 先按照全部时间最小排序，如果相等那么按照收拾东西排序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(scanner.nextLong() + scanner.nextLong(), scanner.nextLong());
        }
        Arrays.sort(nodes, (o1, o2)->{
            if (o1.time1 + o1.time2 == o2.time2 + o2.time1){
                return (int) (o1.time1 - o2.time1);
            }
            return (int) (o1.time1 + o1.time2 - o2.time1 - o2.time2);
        });
        long sum = 0, time = 0;
        for (int i = 0; i < n; i++) {
            time += nodes[i].time1;
            sum += time;
            time += nodes[i].time2;
        }
        System.out.println(sum);
    }

    public static class Node{
        long time1, time2;
        public Node(long time1, long time2){
            this.time1 = time1;
            this.time2 = time2;
        }
    }
}
