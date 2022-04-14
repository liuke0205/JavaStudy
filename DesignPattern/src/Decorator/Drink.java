package Decorator;

/**
 * @author liuke
 * @date 2022/4/15 0:22
 */
public abstract class Drink {
    String des;
    float price;

    public String getDes() {
        return des;
    }

    public float getPrice() {
        return price;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
