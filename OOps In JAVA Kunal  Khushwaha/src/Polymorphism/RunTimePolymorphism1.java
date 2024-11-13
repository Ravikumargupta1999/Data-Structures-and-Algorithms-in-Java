package Polymorphism;


public class RunTimePolymorphism1 {
    public static void main(String[] args) {
        Shape2 shape = new Shape2();
        shape.Area();
        Shape2 shape2 = new Circle2();
        shape2.Area();
        Circle2 circle = new Circle2();
        circle.Area();;
//        Circle2 circle2 = new Shape2();
//        circle2.Area();
    }
}
class Circle2 extends Shape2{
    @Override
    void Area() {
        System.out.println(" I am Overridden");
    }
}
class Shape2{
    void Area()
    {
        System.out.println("I am inside Shape");
    }
}