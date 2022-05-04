package A1B2C3;

/**
 * @author liuke
 * @date 2022/2/21 23:17
 */
public class Synchronized1A2B3C {

    public static void main(String[] args) {
        PrintAB printAB = new PrintAB();
        new Thread(() -> {
            try {
                printAB.PrintNum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();
        new Thread(() -> {
            try {
                printAB.PrintChar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B").start();    }
}

class PrintAB{
    private static int num = 1;
    private static char aChar = 'A';
    public void PrintNum() throws InterruptedException {
        while (num < 4){
            synchronized (PrintAB.class){
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                PrintAB.class.notify();
                if (num < 4){
                    PrintAB.class.wait();
                }
            }
        }
    }

    public void PrintChar() throws InterruptedException {
        while (aChar < 'D'){
            synchronized (PrintAB.class){
                System.out.println(Thread.currentThread().getName() + ":" + aChar++);
                PrintAB.class.notify();
                if (aChar < 'D'){
                    PrintAB.class.wait();
                }
            }
        }
    }
}

