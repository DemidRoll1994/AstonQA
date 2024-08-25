package model.zoo;

public abstract class Animal {
    public String name;
    protected short runMaxDistance = -1;
    protected short swimMaxDistance = -1;
    private static int createdAnimals = 0;

    public Animal(String name) {
        this.name = name;
        createdAnimals++;
    }

    public void run(short distance) {
        if (runMaxDistance < 0) {
            System.out.printf("%s не умеет бегать.", name);
        } else if (runMaxDistance < distance) {
            distance = runMaxDistance;
        }
        System.out.printf("%s пробежал %dм.", name, distance);
    }

    public void swim(short distance) {
        if (swimMaxDistance < 0) {
            System.out.printf("%s не умеет плавать.", name);
        } else if (swimMaxDistance < distance) {
            distance = swimMaxDistance;
        }
        System.out.printf("%s проплыл %dм.", name, distance);
    }

    public static int createdAnimalsCount() {
        return createdAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
