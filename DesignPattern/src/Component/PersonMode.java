package Component;

/**
 * @author liuke
 * @date 2022/4/16 11:42
 */
public abstract class PersonMode {
    private String name;
    private String sex;
    private int age;
    public PersonMode(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonMode{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
