/**
 * @author liuke
 * @date 2022/4/18 22:56
 */
public class StaticTest {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }
}

class A{
    static {System.out.println("父类的静态代码块");}
    {System.out.println("父类的普通代码块");}
    public A(){
        System.out.println("父类的构造方法");
    }
}

class B extends A{
    static {System.out.println("子类的静态代码块");}
    {System.out.println("子类的普通代码块");}
    public B(){
        System.out.println("子类的构造方法");
    }
    public void test(){
        System.out.println("子类的普通方法");
    }
}