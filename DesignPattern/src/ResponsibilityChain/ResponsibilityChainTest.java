package ResponsibilityChain;

/**
 * @author liuke
 * @date 2022/4/7 22:55
 */
public class ResponsibilityChainTest {
    public static void main(String[] args) {
        TechnicalManager technicalManager = new TechnicalManager();
        technicalManager.setNextHandler(new Boss());

        Demand demandA = new Demand();
        demandA.setLevel(1);
        technicalManager.handleMessage(demandA);
        System.out.println("===============================");
        Demand demandB = new Demand();
        demandB.setLevel(2);
        technicalManager.handleMessage(demandB);
    }
}
