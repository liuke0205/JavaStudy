package 笔试真题.拼多多;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * @author liuke
 * @date 2022/3/20 21:07
 */
public class 最多能采摘的西瓜 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n = sc.nextInt();
        int v = sc.nextInt();
        PriorityQueue<Node> heap = new PriorityQueue<>(
            (a, b) -> {
                if (a.start == b.start){
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        );
        int max_end = 0;
        for (int i = 0; i < n; i++) {
            int num  = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            max_end = Math.max(max_end, end);
            Node node = new Node(num, start, end);
            heap.add(node);
        }
        for (int i = 1; i <= max_end; i++) {
            int val = v;
            while (val > 0 && !heap.isEmpty()){
                Node cur = heap.peek();
                if (cur.start > i || cur.end < i){
                    heap.poll();
                    break;
                }
                if (cur.num < val){
                    res += cur.num;
                    val -= cur.num;
                    cur.start = i;
                    heap.poll();
                }else {
                    res += val;
                    cur.num -= val;
                    cur.start = i;
                    heap.poll();
                    heap.add(cur);
                    val = 0;
                }
            }
        }
        System.out.println(res);
    }
}

class Node{
    int num;
    int start;
    int end;
    public Node(int num, int start, int end){
        this.num = num;
        this.start = start;
        this.end = end;
    }
}