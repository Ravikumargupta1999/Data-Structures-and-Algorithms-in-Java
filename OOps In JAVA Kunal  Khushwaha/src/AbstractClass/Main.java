package AbstractClass;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(23);
        System.out.println(son.age);
        son.career("Ravi");
        son.partner("Rishika",23);
        System.out.println("\n");

        Daughter daughter= new Daughter(23);
        System.out.println(daughter.age);
        daughter.career("Rishia");
        daughter.partner("Ravi",23);

        Parent mom = new Parent(45) {
            @Override
            void career(String name) {

            }

            @Override
            void partner(String name, int age) {

            }
        };
    }
}
