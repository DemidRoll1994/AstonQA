package model.geometry;

public class Rectangle extends Shape implements Calculable {

    double[] sides;


    public Rectangle(int RGBFillColor, int RGBBorderColor, double side1, double side2) {
        super(RGBFillColor, RGBBorderColor);
        this.sides = new double[]{side1, side2};
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sides[0] + sides[1]);
    }

    @Override
    public double calculateSquare() {
        return sides[0] * sides[1];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("Perimeter=").append(calculatePerimeter());
        sb.append(", Square=").append(calculateSquare());
        sb.append(", RGBFillColor=").append(RGBFillColor);
        sb.append(", RGBBorderColor=").append(RGBBorderColor);
        sb.append('}');
        return sb.toString();
    }
}
