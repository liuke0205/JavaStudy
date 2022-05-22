package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 19:12
 */
public class 数三角形 {
    /**
     * https://www.nowcoder.com/questionTerminal/21094574ed7e49fe9960e96e52aee1e7
     * 思路：
     * 判定三个点能否构成三角形的条件是：三个点不能处于一条直线（通过判定两个直线的斜率是否相等来判断 -> 乘法）
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    double m1 = (nodes[j].y - nodes[i].y) * (nodes[k].x - nodes[i].x);
                    double m2 = (nodes[k].y - nodes[i].y) * (nodes[j].x - nodes[i].x);
                    if (m1 != m2){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static double getLength(Node node1, Node node2) {
        int m1 = Math.abs(node1.x - node2.x);
        int m2 = Math.abs(node1.y - node2.y);
        return Math.sqrt(m1 * m1 + m2 * m2);
    }

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
