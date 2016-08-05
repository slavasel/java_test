package src.main.java.flowers.classes.flower_architecture;

public abstract class Flower extends FlowerAbstract {

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