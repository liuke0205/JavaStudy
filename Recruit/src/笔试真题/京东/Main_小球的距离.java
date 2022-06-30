package 笔试真题.京东;

import java.util.ArrayList;

/**
 * @author liuke
 * @date 2022/6/21 23:51
 */
public class Main_小球的距离 {
    /**
     * 举个例子，下落高度是x米 ，则有下落后弹起的高度是x/2，
     * 再落下去，又走了一个x/2，依此类推，一直下去，
     * 也就是总距离为 x+2*x（1/2+1/4+1/8+……），
     * 而括号中的数列是一个等比数列，其极限求和的结果就是1。
     * 所以 总距离就是3*x。推理到这里，就发现写程序只需要一行关键代码就可以。
     * @return
     */

    public static void main(String[] args) {
        String s1 = " Topwalk";
        String s2 = " Comapny";
        System.out.println(s2+s1);
        System.out.println(s1.concat(s2));
    }
}
