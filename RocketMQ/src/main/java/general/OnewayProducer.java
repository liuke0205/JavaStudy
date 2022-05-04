package general;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author liuke
 * @date 2022/2/19 0:11
 */
public class OnewayProducer {
    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        // 创建一个生产者，参数为生产者的Group名称
        DefaultMQProducer producer = new DefaultMQProducer("NER");
        // 指定NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 指定新创建的Topic的queue数量，默认为4
        producer.setDefaultTopicQueueNums(2);
        producer.start();

        for (int i = 0; i < 100; i++) {
            byte[] bytes = ("task_id:{" + 1001 + "},text:{东北大学位于辽宁省沈阳市！}").getBytes();
            Message message = new Message("NER", "task", bytes);
            producer.send(message);
        }
        producer.shutdown();
    }
}
