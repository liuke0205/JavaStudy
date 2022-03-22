package 笔试真题.百度;

/**
 * @author liuke
 * @date 2022/3/22 23:15
 */
public class 代码题2 {
    public static void main(String[] args) {
        ClassLoder classLoder = new ClassLoder();
    }
}

class ClassLoder{
    public ClassLoder(){
        System.out.println("构造函数");
    }
    {
        System.out.println("代码块");
    }
    static
    {
        System.out.println("static");
    }
}
