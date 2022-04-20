package Bridge;

/**
 * @author liuke
 * @date 2022/4/21 0:02
 */
public class BridgeTest {
    public static void main(String[] args) {
        HandsetGame handsetGame = new HandsetGame();
        HandsetBrandA brandA = new HandsetBrandA(handsetGame);
        brandA.run();

        HandsetBrandB brandB = new HandsetBrandB(handsetGame);
        brandB.run();
    }
}
