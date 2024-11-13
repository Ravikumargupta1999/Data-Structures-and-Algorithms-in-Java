package AbstractClass;

public class Daughter extends Parent{
    public Daughter(int age)
    {
        super(age);
//        this.age = age;
    }
    @Override
    void career(String name) {
        System.out.println("I am Daughter Class and My name is "+name+" .");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I am Daughter class and my partners name is "+name+" and his age is "+ age+" .");
    }
}
