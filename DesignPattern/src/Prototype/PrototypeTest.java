package Prototype;

/**
 * @author liuke
 * @date 2022/4/3 15:21
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClone shallowClone = new ShallowClone(new User("liuke", 99), "1001");
        ShallowClone clone1 = shallowClone.clone();
        System.out.println(clone1.user == shallowClone.user);   //true

        DeepClone deepClone = new DeepClone(new User("liuke", 99), "1001");
        DeepClone clone2 = deepClone.clone();
        System.out.println(clone2.user == deepClone.user);      //false
    }
}