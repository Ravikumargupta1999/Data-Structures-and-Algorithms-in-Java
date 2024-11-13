package Pattern_Level_1;

public class Pattern_4 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space < (i); space++) {
                System.out.print("   ");
            }
            for (int star = 1; star <= (n - i + 1); star++) {
                System.out.print("*  ");
            }
            System.out.println("");
        }
    }
}
