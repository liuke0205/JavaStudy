package Builder;


public class ComputerBuilder {
    private String cpu;
    private String mouse;

    public ComputerBuilder(String mouse,String cpu) {
        this.mouse = mouse;
        this.cpu = cpu;
    }

    public static Builder newBuilder(){
        return new Builder();
    }
}
