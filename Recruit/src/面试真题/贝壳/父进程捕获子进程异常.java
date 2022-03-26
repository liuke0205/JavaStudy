package 面试真题.贝壳;

import java.util.concurrent.Callable;

import java.util.concurrent.FutureTask;

/**
 * @author liuke
 * @date 2022/3/26 22:21
 */
public class 父进程捕获子进程异常 {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new ThreadException.MyTask());

        new Thread(futureTask).start();
        //通过get方法捕获异常
        try {
            futureTask.get();
        } catch (Exception e) {
            System.out.println("捕获到异常了");
        }
    }
}


class ThreadException {
    static class MyTask implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("执行线程");
            //制造异常
            int a = 3 / 0;
            return 1;
        }
    }
}


/**
 *  异常可能会被子进程吃掉
 */
class ThreadException2 {
    static class MyTask implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("执行线程");
            //制造异常
            int a = 3/0;
            return 1;
        }
    }
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new MyTask());
        //启动线程
        new Thread(futureTask).start();
    }
}