public class classExample9 {
    public static void main(String[] args) {


        Student9 random = new Student9();

        Student9 st1 = new Student9();
        System.out.println(st1.rollno + "   " + st1.name + "    " + st1.marks);

    }
}

class Student9 {
    int rollno;
    String name;
    float marks;

    Student9() {
        this(23,"Rabiii",783);
    }
    Student9(int rollno,String name,float marks)
    {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
}
