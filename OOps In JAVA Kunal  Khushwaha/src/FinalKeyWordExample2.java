public class FinalKeyWordExample2 {
    public static void main(String[] args) {
        final A a = new A("Ravi");
        a.name = "Suyog";
       System.out.println(a.name + "  "+a.num);
//       a.num = 19;

//        a = new A("Rishika");

        final A b = new A("Aman");
//        a = b;
//


    }
}

class A {
    final int num = 10;
    String name;
    A(String name)
    {
        this.name = name;
    }
}
