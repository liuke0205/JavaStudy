package ProductConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuke
 * @date 2022/5/4 22:12
 */
public class ReentrantLockPC {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    queue.put("" + id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "生产者" + i).start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    queue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();
    }
}

class MessageQueue {
    private int cap;
    private LinkedList<String> list = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition productCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();
    public MessageQueue(int size) {
        this.cap = size;
    }
    // 生产者往队列放消息
    public void put(String message) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == cap) {
                System.out.println("队列已满，请等待！");
                productCondition.await();
            }
            list.add(message);
            System.out.println("生产者生产了一条消息：" + message);
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }
    // 消费者往队列拿消息
    public String get() throws InterruptedException {
        String message = "";
        lock.lock();
        try {
            while (list.isEmpty()) {
                System.out.println("队列为空，请等待！");
                consumerCondition.await();
            }
            message = list.removeLast();
            System.out.println("消费者消费了一条消息：" + message);
            productCondition.signal();
        } finally {
            lock.unlock();
        }
        return message;
    }
}
