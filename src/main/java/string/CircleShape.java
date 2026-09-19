package string;

public class CircleShape extends Shape {

    private double radius;

    public CircleShape(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double scaledRadius = radius * scaleFactor;
        return Math.PI * scaledRadius * scaledRadius;
    }
}
