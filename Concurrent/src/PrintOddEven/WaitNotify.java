package PrintOddEven;

/**
 * @author liuke
 * @date 2022/2/21 22:50
 */
public class WaitNotify {
    private static int num;
    private static final Object object = new Object(); // 锁
    public static void main(String[] args) {
        new Thread(new PrintOddEven(), "Even").start();
        new Thread(new PrintOddEven(), "Odd").start();
    }

    static class PrintOddEven implements Runnable{

        @Override
        public void run() {
            while (num < 100){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    object.notify();
                    if (num < 100){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
