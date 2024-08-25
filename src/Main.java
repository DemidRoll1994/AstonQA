import model.geometry.Circle;
import model.geometry.Rectangle;
import model.geometry.Shape;
import model.geometry.Triangle;
import model.zoo.Bowl;
import model.zoo.Cat;

public class Main {
    public static void main(String[] args) {
        feedCats();
        shapesInfo();
    }

    private static void feedCats() {
        Cat[] cats = new Cat[]{
                new Cat("Barsik", 15),
                new Cat("ordinary Barsik", 17),
                new Cat("maxi Barsik", 40),
                new Cat("mini Barsik", 10),
                new Cat("new Barsik"),
                new Cat("new Barsik2", 15),
                new Cat("new Barsik3")
        };
        Bowl bowl = new Bowl();
        bowl.increaseFoodQuantity(100);
        for (Cat cat : cats) {
            System.out.printf("%s is %s \n", cat.getName(), cat.eat(bowl) ?
                    "well-fed" : "hungry");
        }
    }

    private static void shapesInfo() {
        Shape[] shapes = new Shape[]{
                new Circle(0x001122, 0x334455, 5),
                new Rectangle(0x667788, 0x99AABB, 5, 7),
                new Triangle(0xCCDDEE, 0xFF0011, 3, 4, 5)
        };
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

    }
}