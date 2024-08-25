package model.geometry;

public abstract class Shape {
    public int RGBFillColor;
    public int RGBBorderColor;

    public Shape(int RGBFillColor, int RGBBorderColor) {
        this.RGBFillColor = RGBFillColor;
        this.RGBBorderColor = RGBBorderColor;
    }
}
