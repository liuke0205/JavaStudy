package PrintOddEven;

/**
 * @author liuke
 * @date 2022/2/21 23:06
 */
public class Synchronized {

    private static final Object object = new Object();
    private static int num;
    public static void main(String[] args) {
        new Thread(()-> {
                while (num < 100){
                    synchronized (object) {
                        if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                    }
                }

            }
        }, "even").start();

        new Thread(()-> {
            while (num < 100){
                synchronized (object) {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                    }
                }
            }
        }, "odd").start();
    }
}
