package batch;

import org.apache.rocketmq.common.message.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/2/19 19:21
 */
public class MessageListSplitter implements Iterator<List<Message>>{
    // 定义极限值4MB
    private final int SIZE_LIMIT = 4 * 1024 *1024;
    // 存放所有要发送的消息
    private final List<Message> messages;
    // 要批量发送消息的小集合起始索引
    private int currentIndex;

    public MessageListSplitter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < messages.size();
    }

    @Override
    public List<Message> next(){
        int nextIndex = currentIndex;
        int totalSize = 0;
        for (; nextIndex < messages.size(); nextIndex++) {
            Message message = messages.get(nextIndex);

            int tempSize = message.getTopic().length() + message.getBody().length;
            Map<String, String> properties = message.getProperties();
            for (Map.Entry<String, String> entry: properties.entrySet()) {
                tempSize += entry.getKey().length() + entry.getValue().length();
            }
            tempSize += 20; // log长度

            // 判断当前消息本身是否大于4M
            if (tempSize > SIZE_LIMIT){
                if (nextIndex - currentIndex == 0){
                    nextIndex++;
                }
                break;
            }
            if (totalSize + tempSize > SIZE_LIMIT){
                break;
            }else {
                totalSize += tempSize;
            }
        }
        // 获取当前messages列表的子集合[currIndex, nextIndex)
        List<Message> subList = this.messages.subList(currentIndex, nextIndex);
        // 下次遍历的开始索引
        currentIndex = nextIndex;
        return subList;
    }
}
