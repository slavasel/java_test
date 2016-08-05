package src.main.java.flowers.classes.flower_architecture;

import src.main.java.flowers.classes.*;

public class FlowerFactory {

    public Flower createNew (UserFlowerInput flowerData) {
        String flowerType = flowerData.type;
        int length = (int) flowerData.length;
        int lifetime = (int) flowerData.lifetime;
        int price = (int) flowerData.price;
        Flower flower;

        if (flowerType.equals("rose")) {
            flower = new Rose(length, lifetime, price);
        } else if (flowerType.equals("lily")) {
            flower = new Lily(length, lifetime, price);
        } else { //default
            flower = new Rose(10, 0, 10);
        }

        return flower;
    }
}