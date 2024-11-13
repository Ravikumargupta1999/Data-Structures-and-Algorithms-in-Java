public class classExample6 {
    public static void main(String[] args) {
        Student6 st1 = new Student6(55,"Rabi",87);
        System.out.println(st1);
        System.out.println(st1.rollno + "   " + st1.name + "    " + st1.marks);
    }
}

class Student6 {
    int rollno;
    String name;
    float marks;

    Student6(int rollno,String name,float marks) {
        name = name;
        marks = marks;
        rollno = rollno;
    }
}
