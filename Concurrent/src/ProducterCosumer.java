import java.util.LinkedList;

/**
 * @author liuke
 * @create 2021/06/22/22:03
 */
public class ProducterCosumer {
    public static void main(String[] args) {
        Queue queue = new Queue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(id + "");
            }, "生产者" + i).start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String  message = queue.get();
            }
        }, "消费者").start();
    }

}

class Queue{
    private int capacity;
    private LinkedList<String> list = new LinkedList<>();
    public Queue(int capacity){
        this.capacity = capacity;
    }
    public String get(){
        synchronized (list){
            while (list.isEmpty()){
                try {
                    System.out.println("当前没有产品可以消费");
                    list.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            String message = list.removeFirst();
            System.out.println("消费的商品是" + message);
            list.notifyAll();
            return message;
        }
    }

    public void put(String message){
        synchronized (list){
            while(list.size() == capacity){
                try {
                    System.out.println("当前队列已满");
                    list.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            list.notifyAll();
            list.addLast(message);
        }

    }
}
