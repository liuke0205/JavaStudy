package Mediator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liuke
 * @date 2022/4/13 22:54
 */
public class EsDatabase extends AbstractDatabase {
    private List<String> dataset = new CopyOnWriteArrayList<String>();

    public EsDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.ELASTICSEARCH, data);    // 数据同步作业交给中介者管理
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }
}
