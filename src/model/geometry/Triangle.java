package model.geometry;

public class Triangle extends Shape implements Calculable {

    double[] sides;


    public Triangle(int RGBFillColor, int RGBBorderColor, double side1, double side2, double side3) {
        super(RGBFillColor, RGBBorderColor);
        this.sides = new double[]{side1, side2, side3};
    }

    @Override
    public double calculatePerimeter() {
        return sides[0] * sides[1] * sides[2];
    }

    @Override
    public double calculateSquare() {
        double hp = calculatePerimeter() / 2;
        return Math.sqrt(hp * (hp - sides[0]) * (hp - sides[1]) * (hp - sides[2]));
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("Perimeter=").append(calculatePerimeter());
        sb.append(", Square=").append(calculateSquare());
        sb.append(", RGBFillColor=").append(RGBFillColor);
        sb.append(", RGBBorderColor=").append(RGBBorderColor);
        sb.append('}');
        return sb.toString();
    }
}
