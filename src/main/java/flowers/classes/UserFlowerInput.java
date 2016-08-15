package src.main.java.flowers.classes;

public class UserFlowerInput {
    private String type;
    private int length, lifetime, price;

    public UserFlowerInput (String type, int length, int lifetime, int price) {
        this.type = type;
        this.length = length;
        this.lifetime = lifetime;
        this.price = price;
    }

    public String getType () {
        return this.type;
    }

    public int getPrice () {
        return this.price;
    }

    public int getLifetime () {
        return this.lifetime;
    }

    public int getLength () {
        return this.length;
    }
}
