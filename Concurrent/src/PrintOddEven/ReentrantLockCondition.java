package PrintOddEven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuke
 * @date 2022/2/21 22:58
 */
public class ReentrantLockCondition {
    public static void main(String[] args) {
        PrintOddEven oddEven = new PrintOddEven();
        new Thread(oddEven::printOdd, "even").start();
        new Thread(oddEven::printEven, "odd").start();
    }
}

class PrintOddEven{
    private static int num;
    ReentrantLock lock = new ReentrantLock();
    private final Condition odd = lock.newCondition();
    private final Condition even = lock.newCondition();

    public void printOdd(){
        Condition(even, odd);
    }

    public void printEven(){
        Condition(odd, even);
    }

    private void Condition(Condition odd, Condition even) {
        while (num < 100){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                odd.signal();
                if (num < 100){
                    even.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}