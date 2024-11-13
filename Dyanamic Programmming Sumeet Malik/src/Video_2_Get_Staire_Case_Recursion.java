import java.util.ArrayList;
import java.util.Scanner;

public class Video_2_Get_Staire_Case_Recursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<String> paths = getStairPath(n);
        System.out.println("Total no of paths : " + paths.size());
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPath(int n) {
        if (n == 0) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;

        } else if (n < 0) {
            ArrayList<String> paths = new ArrayList<>();
            return paths;
        }
        ArrayList<String> paths1 = getStairPath(n - 1);
        ArrayList<String> paths2 = getStairPath(n - 2);
        ArrayList<String> paths3 = getStairPath(n - 3);
        ArrayList<String> paths = new ArrayList<>();

        for (String path : paths1)
            paths.add(1 + path);

        for (String path : paths2)
            paths.add(2 + path);

        for (String path : paths3)
            paths.add(3 + path);

        return paths;
    }
}
