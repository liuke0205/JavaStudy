package BuilderPattern;


public class ComputerBuilder {
    private String cpu;
    private String keyboard;
    private String mouse;

    public ComputerBuilder(String keyboard, String mouse,String cpu) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.cpu = cpu;
    }

    public static Builder build(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "ComputerBuilder{" +
                "cpu='" + cpu + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
