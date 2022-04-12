package Facede;

/**
 * @author liuke
 * @date 2022/4/13 1:32
 */
public class FacadeTest {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
