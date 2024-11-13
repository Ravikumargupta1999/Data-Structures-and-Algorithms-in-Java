public class classExample {
    public static void main(String[] args) {
        Student st2 ;
//        System.out.println(st2);

        Student st1 = new Student();
        System.out.println(st1);
        System.out.println(st1.marks + "   " + st1.name + "    " + st1.rollo);
    }
    static class Student {
        String name;
        int rollo;
        float marks;
    }
}

//class Student {
//    String name;
//    int rollo;
//    float marks;
//}
