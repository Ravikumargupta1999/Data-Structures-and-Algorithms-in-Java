import java.util.*;

public class Hello {

    static void att(int[] arr) {
        HashSet<Integer> s = new HashSet<>();
        for (int a : arr)
            s.add(a);
        arr = new int[s.size()];
        int k = 0;
        for (int a : s)
            arr[k++] = a;
        Arrays.sort(arr);
        System.out.println("Total present : " + arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println(" ");
        System.out.println("");
        System.out.println("");
        System.out.println("Total Absent : " + (72 - arr.length));
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 1; i <= 72; i++) {
            if (set.contains(i) == false)
                System.out.print(i + "  ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        String str = "EIKT TE COMP A ATTENDANCE";
        System.out.println(str.toUpperCase() + "   " + java.time.LocalDate.now());

        int[] arr = {3,18,38,64,37,53,54,36,28,4,1, 31, 57, 23, 20, 69, 59, 61, 65, 58, 43, 68, 15, 21, 52, 7, 19, 9, 45, 30, 10, 72, 34, 66, 17, 70, 56, 44, 60, 24, 39, 27, 41, 42, 51, 50, 48, 49, 47, 26, 55, 63, 8, 32, 14, 2, 5};
        att(arr);
    }

}
