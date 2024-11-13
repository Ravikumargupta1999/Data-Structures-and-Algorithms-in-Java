public class classExample8 {
    public static void main(String[] args) {
        Student8 st1 = new Student8(55,"Rabi",87);
        System.out.println(st1);
        System.out.println(st1.rollno + "   " + st1.name + "    " + st1.marks);
        System.out.println("\n\n");
        Student8 random = new Student8(st1);
        System.out.println(random.marks);
    }
}

class Student8 {
    int rollno;
    String name;
    float marks;

    Student8(int rollno1,String name1,float marks1) {
        name = name1;
        marks = marks1;
        rollno = rollno1;
    }
    Student8(Student8 other)
    {
        this.rollno = other.rollno;
        this.name = other.name;
        this.marks = other.marks;
    }
}
