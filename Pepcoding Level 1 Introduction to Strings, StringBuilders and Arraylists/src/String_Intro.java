import java.util.Scanner;

public class String_Intro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(a + "  " + b);

        String a1 = sc.nextLine(); // reads compete line including space
        String b1 = sc.next(); // ignores character after space
        System.out.println(a1+"  \n"+b1);
    }
}
