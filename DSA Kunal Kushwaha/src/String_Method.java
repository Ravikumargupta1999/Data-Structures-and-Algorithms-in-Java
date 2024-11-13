import java.util.Arrays;


public class String_Method {
    public static void main(String[] args) {
        String name = "Ravi Kumar Gupta";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toUpperCase());
        name.toUpperCase();
        System.out.println(name+"\n\n");

        name.toLowerCase();
        System.out.println(name+"\n\n");
        System.out.println(name.indexOf(4));
        System.out.println(name.indexOf('a')+"\n\n");

        String str = "      Ravi Rishika  ";
//        System.out.println(str.strip());
//        System.out.println("   Ravi  ".strip());

        System.out.println();
        System.out.println(Arrays.toString(name.split(" ")));
        System.out.println(Arrays.toString("  Ravi hhs kkjsf  ".split(" ")));

    }
}
