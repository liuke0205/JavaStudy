package Mediator;

/**
 * @author liuke
 * @date 2022/4/13 22:43
 */
public abstract class AbstractDatabase {
    public static final String MySQL = "MySQL";
    public static final String REDIS = "Redis";
    public static final String ELASTICSEARCH = "ElasticSearch";
    AbstractMediator mediator;

    public AbstractDatabase(AbstractMediator mediator){
        this.mediator = mediator;
    }
    abstract void addData(String data);
    abstract void add(String data);
}
