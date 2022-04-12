package Facede;

/**
 * @author liuke
 * @date 2022/4/13 1:32
 */
public class ShapeMaker {
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
