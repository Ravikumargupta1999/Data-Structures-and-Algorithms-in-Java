public class StaticExample3 {
    public static void main(String[] args) {
        System.out.println(Human3.population);
        Human3 a = new Human3(21, "Rabi", 160000, false);
        Human3 b = new Human3(21, "Aadarsh", 13000, true);
        System.out.println(a.age + "   " + a.isMarried+"   "+ Human3.population);
        System.out.println(b.age + "   " + b.isMarried+"   "+ Human3.population);
    }
}

class Human3 {
    int age;
    String name;
    float salary;
    boolean isMarried;
    static long population;

    public Human3(int age, String name, float salary, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
        population += 1;
    }
}
