public class StaticExample2 {
    public static void main(String[] args) {


        Human2 a = new Human2(21, "Rabi", 160000, false);
        Human2 b = new Human2(21, "Aadarsh", 13000, true);
        System.out.println(a.age + "   " + a.isMarried+"   "+a.population);
        System.out.println(b.age + "   " + b.isMarried+"   "+b.population);
    }
}

class Human2 {
    int age;
    String name;
    float salary;
    boolean isMarried;
    long population;

    public Human2(int age, String name, float salary, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
        this.population += 1;
    }
}
