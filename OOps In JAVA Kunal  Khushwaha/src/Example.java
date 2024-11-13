public class Example {
    public static void main(String[] args) {
        StudentProfile sb = new StudentProfile(55,"Rabi",98);

    }
}
class StudentProfile{
    int roll;
    String name;
    float marks;
    StudentProfile(int roll,String name,float marks)
    {
        this.roll = roll;
        this.marks = marks;
        this.name = name;
    }

}
