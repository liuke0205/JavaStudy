package 笔试真题.华为;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/25 10:59
 */
public class Main {
    /**
     * 有M个面试官。每个面试官熟悉的编程语言是一个列表（可能熟悉多门语言）
     * 有N个面试者，每个面试者熟悉一门语言，每个面试官最多面试X个人，每个面试者必须被不同的面试官面试两次
     *
     * 请问能否给出一个匹配使得所有的面试者都能被面试官面试
     *
     * 输入：
     * 第一行是3个整数，M,N,X
     * 然后是M行
     * 然后是N行
     *
     * 输出：
     * 第一行是true或false，表示能否匹配
     * 如果能匹配，从第二行输出一个二维数组match
     * match[i][j] 代表第i个面试官是否面试第j个面试者
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);


    }
}
