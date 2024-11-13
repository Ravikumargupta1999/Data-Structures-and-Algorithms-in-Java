import java.util.ArrayList;

public class String_Operator {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" +" b");
        System.out.println('a' + 3);
        System.out.println((char)'a'+3);
        System.out.println((char)('a'+3));
        System.out.println("a"+3);
        System.out.println("Ravi "+new Integer(55));
        System.out.println("Ravi "+ new ArrayList<>());
//        System.out.println(new Integer(34)+ new ArrayList<>());
        System.out.println(new Integer(34)+""+ new ArrayList<>());
    }
}
