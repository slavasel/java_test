package src.main.java.flowers.classes;

public class UserFlowerInput {
    public String type; // нужно сделать приватным, чтобы была инкапсуляция данных. Посмотри видео или почитай зачем нужна инкапсуляция.
    public int length, lifetime, price; // нужно сделать приватным 

    public UserFlowerInput (String type, int length, int lifetime, int price) {
        this.type = type;
        this.length = length;
        this.lifetime = lifetime;
        this.price = price;
    }
}
