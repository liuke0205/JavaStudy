package Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/13 22:49
 */
public class MySQLDatabase extends AbstractDatabase{
    private List<String> dataSet = new ArrayList<>();
    public MySQLDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    void addData(String data) {
        System.out.println("MySQL添加数据：" + data);
        this.dataSet.add(data);
    }

    @Override
    void add(String data) {
        addData(data);
        this.mediator.sync(MySQL, data);
    }

    public void select() {
        System.out.println("Mysql 查询，数据：" + this.dataSet.toString());
    }
}
