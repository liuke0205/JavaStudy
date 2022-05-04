package order;

/**
 * @author liuke
 * @date 2022/5/4 20:15
 */
public class Join {
    public static void main(String[] args) {
        Thread T1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 running....");
        });
        Thread T2 = new Thread(() -> {
            try {
                T1.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 running....");
        });
        Thread T3 = new Thread(() -> {
            try {
                T2.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3 running....");
        });
        T1.start();
        T2.start();
        T3.start();
    }
}


