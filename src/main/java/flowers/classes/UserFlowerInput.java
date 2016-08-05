package src.main.java.flowers.classes;

public class UserFlowerInput {
    public String type;
    public int length, lifetime, price;

    public UserFlowerInput (String type, int length, int lifetime, int price) {
        this.type = type;
        this.length = length;
        this.lifetime = lifetime;
        this.price = price;
    }
}