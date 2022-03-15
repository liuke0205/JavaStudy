package ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author liuke
 * @date 2022/3/13 23:53
 */
public class SimpleThreadPool {
    private int currentSize;
    //存放任务的任务队列
    private static final LinkedList<Runnable> taskQueue = new LinkedList<>();
    //存放线程的链表
    private static final List<WorkerThread> workerThreadList = new ArrayList<>();

    public SimpleThreadPool(int currentSize) {
        this.currentSize = currentSize;
        //对线程组进行初始化
        for (int i = 0; i < currentSize; i++) {
            WorkerThread thread = new WorkerThread();
            thread.start();
            workerThreadList.add(thread);
        }
    }

    public void execute(Runnable task){
        synchronized (taskQueue){
            taskQueue.addLast(task);
            taskQueue.notifyAll();
        }
    }
    /**
     * 定义工作线程的状态
     */
    private enum WorkerThreadState{
        FREE, BLOCK, RUNNING, DEAD
    }
    class WorkerThread extends Thread{
        WorkerThreadState state;
        @Override
        public void run(){
            while(state != WorkerThreadState.DEAD){
                synchronized (taskQueue){
                    while (taskQueue.isEmpty()){
                        try {
                            taskQueue.wait();
                            this.state = WorkerThreadState.BLOCK;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //所有线程并行执行任务
                Runnable task = taskQueue.removeFirst();
                if(task != null){
                    this.state = WorkerThreadState.RUNNING;
                    task.run();
                    this.state = WorkerThreadState.FREE;
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(5);

        IntStream.rangeClosed(0, 50).forEach(i->{
            pool.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "处理任务" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}