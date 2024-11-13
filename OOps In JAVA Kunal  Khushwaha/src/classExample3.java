public class classExample3 {

    public static void main(String[] args) {
//            Student st2 ;
////        System.out.println(st2);
//
        Student3 st1 = new Student3();
        System.out.println(st1);
        System.out.println(st1.marks + "   " + st1.name + "    " + st1.rollo);
        st1.greetins();

    }


}

class Student3 {
    String name;
    int rollo;
    float marks;
    void  greetins()
    {
        System.out.println("Hello my name is : "+name);
    }
    Student3() {
        this.name = "Rabi";
        this.marks = 67;
        this.rollo = 55;
    }
}
