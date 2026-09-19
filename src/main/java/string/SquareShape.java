package string;

public class SquareShape extends Shape {

    private double side;

    public SquareShape(double side) {
        super();
        this.side = side;
    }

    @Override
    public double calculateArea() {
        double scaledSide = side * scaleFactor;
        return scaledSide * scaledSide;
    }
}