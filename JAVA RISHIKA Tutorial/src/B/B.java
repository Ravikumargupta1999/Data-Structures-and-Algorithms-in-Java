package B;

class A{
    void print(){
        System.out.println("Parent Method\n\n");
    }
}
public class B extends A{

    @Override
    void print() {
        System.out.println("Child Method\n\n");
    }

    public static void main(String[] args) {
        A obj1= new A();
        obj1.print();


        B obj2 = new B();
        obj2.print();
    }
}
