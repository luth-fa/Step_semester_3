package string;

public class DrawingCanvasTest {

    static void printArea(Shape s) {
        System.out.println(s.calculateArea());
    }

    public static void main(String[] args) {
        CircleShape c = new CircleShape(5.0);
        SquareShape sq = new SquareShape(4.0);

        System.out.println(c.calculateArea());
        System.out.println(sq.calculateArea());

        sq.scale(2.0);
        System.out.println(sq.calculateArea());

        Shape ref = c;

        printArea(ref);

        System.out.println(c.getShapeId());
        System.out.println(sq.getShapeId());
    }
}