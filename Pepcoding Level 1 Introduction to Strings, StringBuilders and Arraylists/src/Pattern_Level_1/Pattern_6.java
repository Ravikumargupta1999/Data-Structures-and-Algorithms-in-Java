package Pattern_Level_1;

public class Pattern_6 {
    public static void main(String[] args) {
        int n = 7;
        int star = n / 2 + 1;
        int space = 1;
        for (int i = 1; i <= n; i++) {
            printStar(star);
            printSpace(space);
            printStar(star);
            System.out.println("");
            if (i <= n / 2) {
                star--;
                space += 2;
            } else {
                star++;
                space -= 2;
            }
        }
    }

    public static void printSpace(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("\t");
        }

    }

    public static void printStar(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("*\t");
        }

    }
}
