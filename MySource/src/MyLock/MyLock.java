package MyLock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyLock {
    private volatile int state;
    private static Unsafe unsafe;
    private static long stateOffset;

    static {
        try {
            // 使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lock(){
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
