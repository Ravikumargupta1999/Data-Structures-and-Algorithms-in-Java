package Polymorphism;

public class PolymorphismExample1 {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();
        shape.Area();
        circle.Area();
        square.Area();
        System.out.println("\n\n");
        Shapes shape1 = new Square();
        shape1.Area();

    }
}
