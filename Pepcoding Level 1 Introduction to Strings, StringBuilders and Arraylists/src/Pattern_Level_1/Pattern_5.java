package Pattern_Level_1;

public class Pattern_5 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            if (i <= n / 2 + 1) {
                printSpace(n / 2 - i + 1);
                printStar(2 * i - 1);
                printSpace(n / 2 - i + 1);
                System.out.println("");
            } else {
                int j = i - n / 2 -1;
                printSpace(j);
                printStar(n - 2 * j);
                printSpace(j);
                System.out.println("");
            }
        }
    }

    public static void printSpace(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("   ");
        }

    }
    public static void printStar(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("*  ");
        }

    }
}
