package ResponsibilityChain;

/**
 * @author liuke
 * @date 2022/4/7 22:28
 */
public abstract class Handler {
    private Handler nextHandler;
    private final int level;
    public Handler(int level){
        this.level = level;
    }

    // 处理请求传递，注意final，子类不可重写
    public final void handleMessage(Demand demand){
        if (this.level == demand.getLevel()){
            this.report(demand);
        }else {
            if (this.nextHandler != null){
                System.out.println("事情太严重，需要报告上一级");
                this.nextHandler.handleMessage(demand);
            }else {
                System.out.println("我就是boss！");
            }
        }
    }

    // 类似钩子方法
    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    // 抽象类声明，子类必须实现
    public abstract void report(Demand demand);
}
