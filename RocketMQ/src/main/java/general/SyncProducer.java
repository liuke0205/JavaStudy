package general;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author liuke
 * @date 2022/2/18 23:26
 * 生产者同步发送消息
 */
public class SyncProducer {
    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        // 创建一个生产者，参数为生产者的Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        // 指定NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        // 设置当发送失败时重试发送的次数
        producer.setRetryTimesWhenSendFailed(3);
        // 设置生产者的发送超时时间
        producer.setSendMsgTimeout(5000);

        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] bytes = ("Hi" + i).getBytes();
            Message message = new Message("someTopic", "someTag", bytes);
            SendResult send = producer.send(message);
            System.out.println(send);
        }

        producer.shutdown();
    }
}
