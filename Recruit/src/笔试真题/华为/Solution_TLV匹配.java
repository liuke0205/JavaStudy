package 笔试真题.华为;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_TLV匹配 {
    /**
     * 两端通过TLV格式的报文通信，现在收到对端的一个TLV格式的消息包，
     * 要求生成匹配后的（tag，length，valueOffset）列表。具体要求如下：
     *
     * （1）消息包中多组tag、length、value紧密排列，其中tag、length、value紧密排列，其中tag、length各占1字节
     *      value所占字节数等于length的值
     * （2）结果数组中tag值已知，需要填充每个tag对应数据的length 和 valueOffset值
     * （3）消息包和结果数组中的tag值都按升序排列，且不重复
     * （4）此消息包未被篡改，但尾部可能不完整，不完整的一组TLV被抛弃
     *
     * 输入：
     *  0F04ABABABAB
     *  1
     *  15
     * 输出：
     *  4 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
        }

        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < str.length();) {
            String tag = str.substring(i, i+2);
            Integer key = str2int(tag);
            int length = str2int(str.substring(i+2, i+4));
            Node node = new Node(length, i /2 + 2);
            i += (4 + length * 2);
            if (i > str.length()){
                break;
            }
            map.put(key, node);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])){
                Node node = map.get(arr[i]);
                System.out.println(node.length + " " + node.valueOffset);
            }else {
                System.out.println(0 + " " + 0);
            }
        }
    }

    public static int str2int(String string){
        int sum = 0, idx = 0;
        for (int i = string.length() - 1; i >= 0 ; i--) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9'){
                sum += (int) (Math.pow(16, idx)) * (c - '0');
            }else if (c >= 'A' && c <= 'F'){
                sum += (int) (Math.pow(16, idx)) * (c - 'A' + 10);
            }
            idx++;
        }
        return sum;
    }
}

class Node{
    int length;
    int valueOffset;
    public Node(int length, int valueOffset){
        this.length = length;
        this.valueOffset = valueOffset;
    }
}