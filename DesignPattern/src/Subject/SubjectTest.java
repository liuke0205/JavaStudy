package Subject;

/**
 * @author liuke
 * @date 2022/4/9 17:29
 */
public class SubjectTest {
    public static void main(String[] args) {
        // 灰太狼--被观察者
        Wolf wolf = new Wolf();

        // 喜羊羊--观察者
        Observer pleasantSheep = new PleasantSheep();
        // 登记观察者
        wolf.attach(pleasantSheep);

        // 懒羊羊--观察者
        Observer lazySheep = new LazySheep();
        // 登记观察者
        wolf.attach(lazySheep);

        // 灰太狼入侵
        wolf.invade();
    }
}
