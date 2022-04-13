package Mediator;

/**
 * @author liuke
 * @date 2022/4/13 22:44
 */
public abstract class AbstractMediator {
    protected MySQLDatabase mysqlDatabase;
    protected RedisDatabase redisDatabase;
    protected EsDatabase esDatabase;

    public abstract void sync(String databaseName, String data);

    public MySQLDatabase getMysqlDatabase() {
        return mysqlDatabase;
    }

    public void setMysqlDatabase(MySQLDatabase mysqlDatabase) {
        this.mysqlDatabase = mysqlDatabase;
    }

    public RedisDatabase getRedisDatabase() {
        return redisDatabase;
    }

    public void setRedisDatabase(RedisDatabase redisDatabase) {
        this.redisDatabase = redisDatabase;
    }

    public EsDatabase getEsDatabase() {
        return esDatabase;
    }

    public void setEsDatabase(EsDatabase esDatabase) {
        this.esDatabase = esDatabase;
    }
}
