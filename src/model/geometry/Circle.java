package model.geometry;

public class Circle extends Shape implements Calculable {
    double radius;

    public Circle(int RGBFillColor, int RGBBorderColor, double radius) {
        super(RGBFillColor, RGBBorderColor);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double calculateSquare() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("Perimeter=").append(calculatePerimeter());
        sb.append(", Square=").append(calculateSquare());
        sb.append(", RGBFillColor=").append(RGBFillColor);
        sb.append(", RGBBorderColor=").append(RGBBorderColor);
        sb.append('}');
        return sb.toString();
    }
}
