package Prototype;

/**
 * @author liuke
 * @date 2022/2/26 19:21
 */
public class User implements Cloneable{
    private int age;
    private String name;

    public User(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
