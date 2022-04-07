package ResponsibilityChain;

/**
 * @author liuke
 * @date 2022/4/7 22:53
 */
public class Boss extends Handler{
    public Boss() {
        super(2);
    }

    @Override
    public void report(Demand demand) {
        System.out.println("需求：" + demand.getDetail());
        System.out.println(getClass().getSimpleName() + "：你们打一架吧，打赢的做决定");
    }
}
