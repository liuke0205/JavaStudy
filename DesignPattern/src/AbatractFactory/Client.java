package AbatractFactory;

/**
 * @author liuke
 * @create 2021/03/31/18:59
 */
public class Client {
    public static void main(String[] args) {
        IFactory surgicalMaskFactory = new SurgicalMaskFactory();
        // 输出：这是医用口罩
        System.out.println(surgicalMaskFactory.create());
        IFactory N95MaskFactory = new N95MaskFactory();
        // 输出：这是 N95 口罩
        System.out.println(N95MaskFactory.create());
    }
}
