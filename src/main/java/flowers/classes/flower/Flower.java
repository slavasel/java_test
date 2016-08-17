package src.main.java.flowers.classes.flower;

public abstract class Flower implements FlowerAbstract {
    int size = 0;
    int lifetime = 0;
    int price = 0;

    public Flower (int size, int lifetime, int price) {
        this.size = size;
        this.lifetime = lifetime;
        this.price = price;
    }

    public int getPrice () {
        return price;
    }

    public int getLength () {
        return size;
    }

    public int getLifetime () {
        return lifetime;
    }

    public abstract void tellAllAboutThisFlower ();
}