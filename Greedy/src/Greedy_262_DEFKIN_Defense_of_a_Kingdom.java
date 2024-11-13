import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_262_DEFKIN_Defense_of_a_Kingdom {
    // https://www.youtube.com/watch?v=fk1yIirivEo&t=680s
    // https://www.spoj.com/status/ns=29030012
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            a.add(0);
            b.add(0);
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                a.add(x);
                b.add(y);
            }
            a.add(w + 1);
            b.add(h + 1);
            Collections.sort(a);
            Collections.sort(b);
            int width = 0;
            int height = 0;
            for(int i=0;i<a.size()-1;i++){
                width = Math.max(width,a.get(i+1)-a.get(i)-1);
                height = Math.max(height,b.get(i+1)-b.get(i)-1);
            }
            System.out.println(width*height);


        }
    }
}
