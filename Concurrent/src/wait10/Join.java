package wait10;

import java.util.ArrayList;

/**
 * @author liuke
 * @date 2022/5/4 20:55
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "running");
            }, i + "");
            threads.add(thread);
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println("main running");
    }
}
