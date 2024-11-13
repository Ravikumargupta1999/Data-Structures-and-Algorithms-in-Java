import java.util.Arrays;
import java.util.Scanner;

class Employee {

    int n;
    int[] age;
    String[] name;
    int[] salary;
    public Employee(int n){
        this.n = n;
        age = new int[n];
        name = new String[n];
        salary = new int[n];
    }

    public void printDetails() {
        for (int i = 0; i < n; i++) {


            System.out.println("Name of employee : " + name[i]);
            System.out.println("Salary = " + salary[i]);
            System.out.println("Age : " + age[i]);
            System.out.println("________________________");
        }
    }
}

public class oops {
    public static void main(String[] args) {
        int l;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");


        l = sc.nextInt();
        Employee sys = new Employee(l);
        sys.n = l;
        System.out.println(sys.n);

        System.out.println(sys.salary.length);
        for (int i = 0; i < l; i++) {

            System.out.println("Enter name of employee : ");
            sys.name[i] = sc.next();
            System.out.println("Enter salary : ");
            sys.salary[i] = sc.nextInt();
            System.out.println("Enter Age : ");
            sys.age[i] = sc.nextInt();
        }
        sys.printDetails();


    }
}
