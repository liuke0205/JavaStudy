package PrintAB;

/**
 * @author liuke
 * @date 2022/5/4 19:27
 */
public class Test {
    static Object object = new Object();

    public static void main(String[] args) {
        PrintA printA = new PrintA();
        PrintB printB = new PrintB();
        new Thread(printA, "A").start();
        new Thread(printB, "B").start();
    }

    static class PrintA implements Runnable{
        int num = 0;
        @Override
        public void run() {
            while (num < 10){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + ":" + "A");
                    num++;
                    object.notify();
                    if (num < 10){
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

    static class PrintB implements Runnable{
        int num = 0;

        @Override
        public void run() {
            while (num < 10){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + ":" + "B");
                    num++;
                    object.notify();
                    if (num < 10){
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



