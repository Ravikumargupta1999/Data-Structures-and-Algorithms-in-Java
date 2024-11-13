public class ObjectExample {
    static void print() {
        System.out.println("static method");
    }

    void add(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        // calling static method
        print();

        //
        ObjectExample obj = new ObjectExample();
        // calling non-static method
        obj.add(10, 20);
    }
}
