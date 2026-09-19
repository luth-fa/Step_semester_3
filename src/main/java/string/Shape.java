package string;

public abstract class Shape {

    private static int shapeCounter = 0;
    private final String shapeId;
    protected double scaleFactor = 1.0;

    public Shape() {
        shapeCounter++;
        shapeId = "SHAPE-" + (1000 + shapeCounter);
    }

    public abstract double calculateArea();

    public void scale(double factor) {
        scaleFactor = scaleFactor * factor;
    }

    public void scale(double xFactor, double yFactor) {
        scale(xFactor);
        scale(yFactor);
    }

    public String getShapeId() {
        return shapeId;
    }
}