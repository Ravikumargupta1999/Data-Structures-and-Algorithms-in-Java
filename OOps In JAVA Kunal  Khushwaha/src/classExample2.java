public class classExample2 {

    public static void main(String[] args) {
//            Student st2 ;
////        System.out.println(st2);
//
        Student1 st1 = new Student1();
        System.out.println(st1);
        System.out.println(st1.marks + "   " + st1.name + "    " + st1.rollo);

    }


}

class Student1 {
    String name;
    int rollo;
    float marks;

    Student1() {
        this.name = "Rabi";
        this.marks = 67;
        this.rollo = 55;
    }
}
