package model.zoo;

public class Cat extends Animal {
    private static int createdCats = 0;
    private int satiety = 0;
    private int maxSatiety = 20;
    boolean isFull = false;

    public Cat(String name) {
        super(name);
        runMaxDistance = 200;
        createdCats++;
    }

    public Cat(String name, int maxSatiety) {
        this(name);
        this.maxSatiety = maxSatiety;
    }

    public static int createdCatsCount() {
        return createdCats;
    }

    public boolean eat(Tableware tableware) {
        int needsSatiety = maxSatiety - satiety;
        isFull = tableware.decreaseFoodQuantity(needsSatiety);
        return isFull;
    }

}
