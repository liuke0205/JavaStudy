package ResponsibilityChain;

/**
 * @author liuke
 * @date 2022/4/7 22:52
 */

// 技术经理
public class TechnicalManager extends Handler{

    public TechnicalManager() {
        super(1);
    }

    @Override
    public void report(Demand demand) {
        System.out.println("需求：" + demand.getDetail());
        System.out.println(getClass().getSimpleName() + "：小猿我挺你，这个需求不干");
    }

}
