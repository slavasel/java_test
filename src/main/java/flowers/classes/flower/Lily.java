package src.main.java.flowers.classes.flower;

public class Lily extends Flower {
    private boolean hasSharps = false;

    public Lily (int size, int lifetime, int price) {
        super(size, lifetime, price);
    }

    public void tellAllAboutThisFlower () {
        System.out.println("Lily, which is " + lifetime + " days old");
    };
}