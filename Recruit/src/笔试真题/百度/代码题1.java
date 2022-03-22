package 笔试真题.百度;

/**
 * @author liuke
 * @date 2022/3/22 22:52
 */
public class 代码题1 {
    public static void main(String[] args) {
        Demo demo = new Demo();
    }
}


class Demo{
    public static Demo d1 = new Demo();
    {
        System.out.println("code line 1");
    }
    static
    {
        System.out.println("code line 2");
    }
}