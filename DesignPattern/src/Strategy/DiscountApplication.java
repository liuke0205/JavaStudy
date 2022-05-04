package Strategy;

/**
 * @author liuke
 * @date 2022/4/3 11:13
 */
public class DiscountApplication {
    public static void main(String[] args) {
        Context context = new Context(new Discount85Strategy());
        System.out.println(context.exec(100));
    }
    /**
     *
     * 1. 单点登录相关问题扩展+整理
     * 2. 用户故事补充
     * 3. 技术栈部分 每个技术对应的功能
     * 4. 通用问题回答
     *
     */
}
