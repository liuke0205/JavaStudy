package Template;

/**
 * @author liuke
 * @date 2022/4/7 0:48
 */
public abstract class SoyaMilk {
    void select(){
        System.out.println("挑选大豆");
    }
    abstract void add();
    void soak(){
        System.out.println("浸泡");
    }
    void beat(){
        System.out.println("打浆");
    }
    boolean isAdd(){
        return true;
    }
    final void make(){
        select();
        if (isAdd()){
            add();
        }
        soak();
        beat();
    }
}
