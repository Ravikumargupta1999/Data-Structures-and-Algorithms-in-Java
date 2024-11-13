import java.util.Arrays;
import java.util.HashMap;

public class Video_20_Words_K_Selection_5 {
    public static void main(String[] args) throws Exception {
        String str = "geeksforgeeks";
        int k = 4;
        fun(0, str, 0, k, new int[k]);
        System.out.println("\n\n\nTotal String : " + count);
    }

    static int count = 0;

    public static void fun(int idx, String str, int selectedSoFar, int totalSelection, int[] spots) {


        if (selectedSoFar == totalSelection) {
            count++;
            for (int val : spots) {
                char ch = (char)val;
                System.out.print( ch+ " ");
            }
            System.out.println();
            return;
        }
        if (idx == str.length())
            return;
        char ch = str.charAt(idx);
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == 0) {
                spots[i] = ch;
                fun(idx + 1, str, selectedSoFar + 1, totalSelection, spots);
                spots[i] = 0;
            }
        }
    }
}



