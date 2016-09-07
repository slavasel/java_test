package src.main.java.flowers.classes;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import src.main.java.flowers.classes.flower.*;

public class UserInterface {

    private FlowerCollection fc;
    private Scanner scanner = new Scanner(System.in);
    private final String ANSI_CLS = "\u001b[2J";
    private final String ANSI_HOME = "\u001b[H";

    public UserInterface () {
        fc = new FlowerCollection();
    }

    public void start () {
        showDescription();
        listenUserInteractions();
    }

    private void showDescription () {
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        System.out.println( "<==========================>" +
                            "\n Please select an action:" +
                            "\n Type 'add' to add a flower" +
                            "\n Type 'total' to see total price for added flowers" +
                            "\n Type 'sort' to sort by a fresh status" +
                            "\n Type 'filter' to filter by a flower length" +
                            "\n Type 'list' to see a list of flowers" +
                            "\n\n Type 'exit' to quit" +
                            "\n<==========================>");
    }

    private void listenUserInteractions () {
        // Scanner will listen to the user's input
        String selection = scanner.next();

        if (!selection.equals("exit")) { // лучше сделать через case. 
        //Содержимого каждого if лучше сделать отдельным методом и этим методам дать понятные имена, 
        //т.о. можно избавиться от комментариев и сделать самодокументируемый код
            // Adding a Flower
            if (selection.equals("add")) {
                UserFlowerInput flowerData;
                try {
                    flowerData = gatherFlowerData();
                } catch (InvalidNameException e) {
                    System.out.println(e);
                    wait(2);
                    showDescription();
                    listenUserInteractions();
                    return;
                }

                fc.addFlowerToCollection(flowerData);

                log("Flower has been added");
                wait(2); // вместо вейтов, лучше было добавить ожидание до нажатия на любую кнопку
                start();
            }

            // Showing a list
            if (selection.equals("list")) {
                fc.showInfo();
                wait(5);
                start();
            }

            // Calculating total price
            if (selection.equals("total")) {
                String total = fc.getTotalPrice();
                log(total);
                wait(2);
                start();
            }

            // Show filtered data
            if (selection.equals("filter")) {
                int[] filterData = gatherLengthFilter();

                for (Flower flower: fc.getCollection()) {
                    if (flower.getLength() > filterData[0] && flower.getLength() < filterData[1]) {
                        flower.tellAllAboutThisFlower();
                    }
                }

                wait(5);
                start();
            }

            // Sort by lifetime
            if (selection.equals("sort")) {
                fc.sortByLifetime();
                fc.showInfo();
                wait(5);
                start();
            }
        }
    }

    private UserFlowerInput gatherFlowerData() throws InvalidNameException {
        // ask use to fill all required data
        log("Enter type (rose, lily):");
        String type = scanner.next(); // нужно сразу проверить, чтобы вводили только rose или lily. Т.к. валидатор вызывается только после того как все ввели.

        if (!(type.equals("rose") || type.equals("lily"))) {
            throw new InvalidNameException("Flower is not available");
        }

        log("Enter length (mm):");
        int length = scanner.nextInt();

        log("How old is a flower? (days)");
        int lifetime = scanner.nextInt();

        log("How much it costs? ($)");
        int price = scanner.nextInt();

        UserFlowerInput ret = new UserFlowerInput(type, length, lifetime, price);
        return ret;
    }

    private int[] gatherLengthFilter () {  // лучше было бы вернуть массив int а не Integer. Но даже в данном случае в строке 79 можно не делеть приведение типов.
    //Почитай про исходящее и нисходящее приобразование типов а также по автобоксинг и автоанбоксинг
        log("Enter min length:");
        Integer l1 = scanner.nextInt();

        log("Enter max lenth:");
        Integer l2 = scanner.nextInt();

        int[] ret = {l1, l2};
        return ret;
    }

    private boolean validateFlower (UserFlowerInput FlowerData) {
        if (!Arrays.asList(fc.FLOWER_TYPES).contains(FlowerData.getType())) {
            log("Sorry. We don't have this flower in our store. Please, try again");
            return false;
        }

        return true;
    }

    private void wait (int seconds) {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < seconds * 1000) {
            // wait
        }
    }

    private void log (String msg) {
        System.out.println("\n" + msg + "\n");
    }
}
