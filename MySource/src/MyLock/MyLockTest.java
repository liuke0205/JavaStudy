package MyLock;

public class MyLockTest {
    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();
        new Thread(()->{
            myLock.lock();
            try {
                doSomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unlock();
        }, "A").start();
        new Thread(()->{
            myLock.lock();
            try {
                doSomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            myLock.unlock();
        }, "B").start();
    }
    public static void doSomeThing() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "正在执行！");
        Thread.sleep(1000);
    }
}
