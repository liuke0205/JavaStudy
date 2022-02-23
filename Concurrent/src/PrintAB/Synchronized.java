package PrintAB;

/**
 * @author liuke
 * @date 2022/2/21 23:17
 */
public class Synchronized {

    public static void main(String[] args) {
        PrintAB printAB = new PrintAB();
        new Thread(() -> {
            try {
                printAB.PrintA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();
        new Thread(() -> {
            try {
                printAB.PrintB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B").start();    }
}

class PrintAB{
    private static int numA, numB;
    public void PrintA() throws InterruptedException {
        while (numA < 10){
            synchronized (PrintAB.class){
                System.out.println(Thread.currentThread().getName() + ":" + "A");
                numA++;
                PrintAB.class.notify();
                if (numA < 10){
                    PrintAB.class.wait();
                }
            }
        }
    }

    public void PrintB() throws InterruptedException {
        while (numB < 10){
            synchronized (PrintAB.class){
                System.out.println(Thread.currentThread().getName() + ":" + "B");
                numB++;
                PrintAB.class.notify();
                if (numA < 10){
                    PrintAB.class.wait();
                }
            }
        }
    }
}