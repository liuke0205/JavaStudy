package FactoryPattern;

/**
 * @author liuke
 * @create 2021/03/31/18:59
 */
public class Client {
    public static void main(String[] args) {
        MaskFactory factory = new MaskFactory();
        // 输出：这是医用口罩
        System.out.println(factory.create("Surgical"));
        // 输出：这是 N95 口罩
        System.out.println(factory.create("N95"));
    }
}
