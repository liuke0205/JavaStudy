package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 15:59
 */
public class 列表补全 {
    /**
     * https://www.nowcoder.com/questionTerminal/8d677d9c6af643f28c2153ee4e435ea4
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String[] arr = scanner.nextLine().split(" ");
            int offset = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            int L1 = Integer.parseInt(arr[2]);
            int L2 = Integer.parseInt(arr[3]);
            int start1 = 0, end1 = 0, start2 = 0, end2 = 0;
            // 两边都需要跳过
            if (offset >= L1 + L2){
                start1 = L1;
                end1 = L1;
                start2 = L2;
                end2 = L2;
            }
            else if (offset < L1){// 需要从L1选取商品
                // 计算从L1选取的长度
                if (offset + n > L1){
                    start1 = offset;
                    end1 = L1;
                    end2 = offset + n - L1;
                }else {
                    start1 = offset;
                    end1 = offset + n;
                }
            }else { // 直接全部从L2选取
                start1 = L1;
                end1 = L1;
                start2 = offset - L1;
                end2 = offset - L1 + n;
            }
            if (end2 > L2){
                end2 = L2;
            }
            System.out.printf("%d %d %d %d", start1, end1, start2, end2);
            System.out.println();
        }
    }
}
