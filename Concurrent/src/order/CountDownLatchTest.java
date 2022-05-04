package order;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuke
 * @date 2022/5/4 20:27
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch c0 = new CountDownLatch(0);
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);
        new Thread(new Work(c0, c1), "T1").start();
        new Thread(new Work(c1, c2), "T2").start();
        new Thread(new Work(c2, c2), "T3").start();
    }

    static class Work implements Runnable{
        CountDownLatch c1, c2;
        public Work(CountDownLatch c1, CountDownLatch c2){
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                c1.await();
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
