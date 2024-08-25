package model.zoo;

public class Dog extends Animal {
    private static int createdDogs = 0;

    public Dog(String name) {
        super(name);
        runMaxDistance = 500;
        swimMaxDistance = 10;
        createdDogs++;
    }

    public static int createdDogsCount() {
        return createdDogs;
    }
}
