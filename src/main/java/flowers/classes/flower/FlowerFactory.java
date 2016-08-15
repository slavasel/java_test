package src.main.java.flowers.classes.flower;

import src.main.java.flowers.classes.*;

public class FlowerFactory {

    public Flower createNew (UserFlowerInput flowerData) {
        String flowerType = flowerData.getType();
        int length = (int) flowerData.getLength();
        int lifetime = (int) flowerData.getLifetime();
        int price = (int) flowerData.getPrice();
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