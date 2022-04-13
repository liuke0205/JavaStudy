package Mediator;

/**
 * @author liuke
 * @date 2022/4/13 22:57
 */
public class SyncMediator extends AbstractMediator{
    @Override
    public void sync(String databaseName, String data) {
        if (AbstractDatabase.MySQL.equals(databaseName)){
            // mysql 同步到 redis 和 Elasticsearch
            this.redisDatabase.addData(data);
            this.esDatabase.add(data);
        }else if (AbstractDatabase.REDIS.equals(databaseName)){
            // redis 缓存同步，不需要同步到其他数据库
        }else if (AbstractDatabase.ELASTICSEARCH.equals(databaseName)){
            // Elasticsearch 同步到 Mysql
            this.mysqlDatabase.addData(data);
        }
    }
}
