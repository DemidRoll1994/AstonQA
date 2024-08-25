package model.geometry;

public abstract class Shape {
    public int RGBFillColor = 0;
    public int RGBBorderColor = 0;

    public Shape(int RGBFillColor, int RGBBorderColor) {
        this.RGBFillColor = RGBFillColor;
        this.RGBBorderColor = RGBBorderColor;
    }
}
