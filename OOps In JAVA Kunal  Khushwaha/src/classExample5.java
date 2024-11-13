public class classExample5 {

    public static void main(String[] args) {
        Student5 st1 = new Student5();
        System.out.println(st1);
        System.out.println(st1.marks + "   " + st1.name + "    " + st1.rollo);
    }
}

class Student5 {
    String name;
    int rollo;
    float marks;

    Student5() {
        name = "Rabi";
        marks = 67;
        rollo = 55;
    }
}
