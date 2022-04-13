package Mediator;

/**
 * @author liuke
 * @date 2022/4/13 23:00
 */
public class MediatorTest {
    public static void main(String[] args) {
        AbstractMediator syncMediator = new SyncMediator();
        MySQLDatabase mysqlDatabase = new MySQLDatabase(syncMediator);
        RedisDatabase redisDatabase = new RedisDatabase(syncMediator);
        EsDatabase esDatabase = new EsDatabase(syncMediator);

        syncMediator.setMysqlDatabase(mysqlDatabase);
        syncMediator.setRedisDatabase(redisDatabase);
        syncMediator.setEsDatabase(esDatabase);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中-----------");
        mysqlDatabase.add("1");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------Redis添加数据 2，将不同步到其它数据库-----------");
        redisDatabase.add("2");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------ES 添加数据 3，只同步到 Mysql-----------");
        esDatabase.add("3");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();
    }
}
