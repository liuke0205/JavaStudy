package Template;

/**
 * @author liuke
 * @date 2022/4/7 0:52
 */
public class TemplateTest {
    public static void main(String[] args) {
        System.out.println("=================黑豆豆浆制作=================");
        new BlackBeanSoyaMilk().make();
        System.out.println("=================纯豆浆制作=================");
        new PureSoyaMilk().make();
    }
}
