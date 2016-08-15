package src.main.java.flowers.classes.flower;

public class Rose extends Flower {
    private boolean hasSharps = true;

    public Rose (int size, int lifetime, int price) {
        super(size, lifetime, price);
    }

    public void tellAllAboutThisFlower () {
        System.out.println("Rose with size=" + this.size + "mm and " + lifetime + " days old");
    };
}