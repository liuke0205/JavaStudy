package 双指针;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/31 23:17
 */
public class VisibilityTest {
    private volatile static boolean flag = true;
    public static void main(String[] args) {
        new Thread(()->{
            while (flag){ }
        }).start();

        //主线程休眠2s再执行下面的线程目的是让flag变量变成热点数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            flag = false;
            System.out.println("flag的值为:false" );
        }).start();
    }
}
