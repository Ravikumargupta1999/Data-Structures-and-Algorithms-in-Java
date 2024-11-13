import java.util.Scanner;

public class LastIndexofOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int value = lastIndex(str);
        System.out.println(value);
    }

    public static int lastIndex(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                return i;
        }
        return -1;
    }
}
