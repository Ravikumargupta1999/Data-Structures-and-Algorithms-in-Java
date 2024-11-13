public class classExample7 {
    public static void main(String[] args) {
        Student7 st1 = new Student7(55,"Rabi",87);
        System.out.println(st1);
        System.out.println(st1.rollno + "   " + st1.name + "    " + st1.marks);
    }
}

class Student7 {
    int rollno;
    String name;
    float marks;

    Student7(int rollno1,String name1,float marks1) {
        name = name1;
        marks = marks1;
        rollno = rollno1;
    }
}
