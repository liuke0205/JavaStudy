package Mediator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/13 22:54
 */
public class RedisDatabase extends AbstractDatabase {
    private List<String> dataset = new LinkedList<String>();

    public RedisDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.REDIS, data);    // 数据同步作业交给中介者管理
    }

    public void cache() {
        System.out.println("Redis 缓存的数据：" + this.dataset.toString());
    }
}
