package src.main.java.flowers.classes;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import src.main.java.flowers.classes.flower_architecture.*;

public class UserInterface {

    private FlowerCollection fc;
    private Scanner scanner = new Scanner(System.in);
    private final String ANSI_CLS = "\u001b[2J";
    private final String ANSI_HOME = "\u001b[H";

    public UserInterface () {
        this.fc = new FlowerCollection(); // this в Джаве пишут только если перекрываются области видимости переменных с одинаковыми именами.
    }

    public void start () {
        this.showDescription();
        this.listenUserInteractions();
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
                UserFlowerInput flowerData = this.gatherFlowerData();
                while (!this.validateFlower(flowerData)) {
                    flowerData = this.gatherFlowerData();
                }

                fc.addFlowerToCollection(flowerData);

                this.log("Flower has been added");
                this.wait(2); // вместо вейтов, лучше было добавить ожидание до нажатия на любую кнопку
                this.start();
            }

            // Showing a list
            if (selection.equals("list")) {
                this.fc.showInfo();
                this.wait(5);
                this.start();
            }

            // Calculating total price
            if (selection.equals("total")) {
                String total = this.fc.getTotalPrice();
                this.log(total);
                this.wait(2);
                this.start();
            }

            // Show filtered data
            if (selection.equals("filter")) {
                Integer[] filterData = this.gatherLengthFilter();

                for (Flower flower: this.fc.getCollection()) {
                    if (flower.getLength() > (int) filterData[0] && flower.getLength() < (int) filterData[1]) {
                        flower.tellAllAboutThisFlower();
                    }
                }

                this.wait(5);
                this.start();
            }

            // Sort by lifetime
            if (selection.equals("sort")) {
                this.fc.sortByLifetime();
                this.fc.showInfo();
                this.wait(5);
                this.start();
            }
        }
    }

    private UserFlowerInput gatherFlowerData () {
        // ask use to fill all required data
        this.log("Enter type (rose, lily):");
        String type = scanner.next(); // нужно сразу проверить, чтобы вводили только rose или lily. Т.к. валидатор вызывается только после того как все ввели.

        this.log("Enter length (mm):");
        int length = scanner.nextInt();

        this.log("How old is a flower? (days)");
        int lifetime = scanner.nextInt();

        this.log("How much it costs? ($)");
        int price = scanner.nextInt();

        UserFlowerInput ret = new UserFlowerInput(type, length, lifetime, price);
        return ret;
    }

    private Integer[] gatherLengthFilter () {  // лучше было бы вернуть массив int а не Integer. Но даже в данном случае в строке 79 можно не делеть приведение типов.
    //Почитай про исходящее и нисходящее приобразование типов а также по автобоксинг и автоанбоксинг
        this.log("Enter min length:");
        Integer l1 = scanner.nextInt();

        this.log("Enter max lenth:");
        Integer l2 = scanner.nextInt();

        Integer[] ret = {l1, l2};
        return ret;
    }

    private boolean validateFlower (UserFlowerInput FlowerData) {
        if (!Arrays.asList(this.fc.FLOWER_TYPES).contains(FlowerData.type)) {
            this.log("Sorry. We don't have this flower in our store. Please, try again");
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
