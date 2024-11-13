import java.util.Scanner;

public class Case_check {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for(int  i=0;i<3;i++)
            System.out.println(s.next());
        System.out.println("Hello World !!\n\n");


        for (int i=0;i<3;i++) {
            System.out.println(s.next().trim().charAt(0));
        }

    }
}
