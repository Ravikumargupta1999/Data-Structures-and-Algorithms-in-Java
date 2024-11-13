public class classExample4 {

    public static void main(String[] args) {

//
        Student4 st1 = new Student4();
//        System.out.println(st1);
//        System.out.println(st1.marks + "   " + st1.name + "    " + st1.rollo);
        st1.greetins();
        st1.changeName("Suyog");
        st1.greetins();

    }


}

class Student4 {
    String name;
    int rollo;
    float marks;
    void  greetins()
    {
        System.out.println("Hello my name is : "+name);
    }
    void changeName(String name)
    {
        this.name = name;
    }
    Student4() {
        this.name = "Rabi";
        this.marks = 67;
        this.rollo = 55;
    }
}
