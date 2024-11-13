
package Polymorphism;

public class ComplileTimePolymorphism1 {
    public static void main(String[] args) {
        Numbers1 obj = new Numbers1();
        System.out.println(obj.sum(3,4));
        System.out.println("");
        System.out.println(obj.sum(678.0,56.0));
    }
}
class Numbers1{
    int sum(int a,int b)
    {
        System.out.println("Integer");
        return a + b;
    }
    double sum(double a,double b)
    {
        System.out.println("Double");
        return a + b;
    }
}