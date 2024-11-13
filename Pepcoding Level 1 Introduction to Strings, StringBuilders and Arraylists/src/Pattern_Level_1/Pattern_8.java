package Pattern_Level_1;

public class Pattern_8 {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == n - i + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println("");

        }
    }
}
