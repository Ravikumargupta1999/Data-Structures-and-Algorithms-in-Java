package AbstractClass;

public class Son extends Parent{
    public Son(int age)
    {
        super(age);
//        this.age = age;
    }
    @Override
    void career(String name) {
        System.out.println("I am Son Class and My name is "+name+" .");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I am son class and my partners name is "+name+" and her age is "+ age+" .");
    }
}
