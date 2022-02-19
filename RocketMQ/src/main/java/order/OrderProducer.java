package order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author liuke
 * @date 2022/2/19 12:13
 */
public class OrderProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 创建一个生产者，参数为生产者的Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        // 指定NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        producer.start();

        for (int i = 0; i < 100; i++) {
            Integer orderId = i;
            byte[] bytes = ("Hi" + i).getBytes();
            Message message = new Message("TopicA", "TagA", bytes);
            // send() 中的第三个参数 就是 选择器中的第三个参数
            SendResult result = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id =(Integer) o;
                    int index = id % list.size();
                    return list.get(index);
                }
            }, orderId);
            System.out.println(result);
        }
        producer.shutdown();
    }
}
