package Lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

class Lock {
    private volatile int state;
    private static Unsafe unsafe;
    private static long stateOffset;
    ReentrantLock lock = new ReentrantLock();
    static {
        try {
            // 使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(Lock.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    public void lock(){
        lock.lock();
        //CAS将0改成1
        while (!unsafe.compareAndSwapInt(this, stateOffset, 0, 1)){
            System.out.println(Thread.currentThread().getName() + "被阻塞");
        }
        //执行到此，表示获取到锁
        System.out.println(Thread.currentThread().getName() + "成功获取锁");
        state = 1;
    }

    public void unlock(){
        state = 0;
    }
}

public class LockCAS{
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        new Thread(()->{
            lock.lock();
            try {
                doSomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "A").start();
        new Thread(()->{
            lock.lock();
            try {
                doSomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "B").start();
    }
    public static void doSomeThing() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "正在执行！");
        Thread.sleep(1000);
    }
}