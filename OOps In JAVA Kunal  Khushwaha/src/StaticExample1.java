public class StaticExample1 {
    public static void main(String[] args) {


        Human1 a = new Human1(21, "Rabi", 160000, false);
        Human1 b = new Human1(21, "Aadarsh", 13000, true);
        System.out.println(a.age+"   "+a.isMarried);
        System.out.println(b.age+"   "+b.isMarried);
    }
}

class Human1 {
    int age;
    String name;
    float salary;
    boolean isMarried;

    public Human1(int age, String name, float salary, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
    }
}
