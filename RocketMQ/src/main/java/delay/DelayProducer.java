package delay;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author liuke
 * @date 2022/2/19 14:08
 */
public class DelayProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 创建一个生产者，参数为生产者的Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        // 指定NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] bytes = ("Hi" + i).getBytes();
            Message message = new Message("TopicB", "TagB", bytes);
            message.setDelayTimeLevel(4);
            SendResult send = producer.send(message);
            System.out.println(new SimpleDateFormat("mm:ss").format(new Date()));
            System.out.println(send);
        }

        producer.shutdown();
    }
}
