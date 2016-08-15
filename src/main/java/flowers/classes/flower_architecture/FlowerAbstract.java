package src.main.java.flowers.classes.flower_architecture;

public abstract class FlowerAbstract { // лучше было сделать интерфейсом, т.к. тут нет реализованых методов. 
//Мы можем реализовать несколько интерфейсов а унаследоваться только от одного класса
    protected int size = 0;
    protected int lifetime = 0;
    protected int price = 0;

    abstract void tellAllAboutThisFlower ();
}
