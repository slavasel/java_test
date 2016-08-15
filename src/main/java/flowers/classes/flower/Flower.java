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
        return this.price;
    }

    public int getLength () {
        return this.size;
    }

    public int getLifetime () {
        return this.lifetime;
    }

    public abstract void tellAllAboutThisFlower ();
}