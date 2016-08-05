package src.main.java.flowers.classes.flower_architecture;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import src.main.java.flowers.classes.*;

public class FlowerCollection {

    public final static String[] FLOWER_TYPES = {"rose", "lily"};
    private ArrayList<Flower> flowers = new ArrayList<Flower>();
    private FlowerFactory flowerFactory = new FlowerFactory();
    private boolean insertDummyData = true;

    public FlowerCollection () {
        // dummy data (for fast testing)
        if (this.insertDummyData) {
            this.addDummyData();
        }
    }

    public void addFlowerToCollection (UserFlowerInput flowerData) {
        Flower flower = this.flowerFactory.createNew(flowerData);
        this.flowers.add(flower);
    }

    public void showInfo () {
        for (Flower flower: this.flowers) {
            flower.tellAllAboutThisFlower();
        }
    }

    public String getTotalPrice () {
        int total = 0;
        for (Flower flower: this.flowers) {
            total += flower.getPrice();
        }
        return "Total price is $" + total;
    }

    public void sortByLifetime () {
        Collections.sort(this.flowers, new Comparator<Flower>() {
            public int compare(Flower s1, Flower s2) {
                return s1.getLifetime() > s2.getLifetime() ? 1 : -1;
            }
        });
    }

    public ArrayList<Flower> getCollection () {
        return this.flowers;
    }

    private void addDummyData () {
        Flower f1 = flowerFactory.createNew(new UserFlowerInput("rose", 50, 5, 20));
        this.flowers.add(f1);

        Flower f2 = flowerFactory.createNew(new UserFlowerInput("lily", 30, 2, 40));
        this.flowers.add(f2);

        Flower f3 = flowerFactory.createNew(new UserFlowerInput("rose", 10, 10, 40));
        this.flowers.add(f3);
    }
}