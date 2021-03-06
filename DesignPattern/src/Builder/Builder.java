package Builder;

public class Builder {
    private String cpu;
    private String mouse;
    public Builder(){}

    public Builder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public Builder setMouse(String mouse) {
        this.mouse = mouse;
        return this;
    }

    public ComputerBuilder builder(){
        return new ComputerBuilder(mouse, cpu);
    }
}
