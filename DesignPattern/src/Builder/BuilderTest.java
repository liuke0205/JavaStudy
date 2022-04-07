package Builder;

public class BuilderTest {
    public static void main(String[] args) {
        ComputerBuilder builder = ComputerBuilder.newBuilder().
                setCpu("i3").
                setMouse("单飞燕鼠标").
                builder();
        System.out.println(builder.toString());
    }
}
