import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/sort-string/0/?problemType=full&page=1&query=problemTypefullpage1

public class Sort_String {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            char[] ch = S.toCharArray();
            Arrays.sort(ch);
            S = String.valueOf(ch);
            System.out.println(S);
        }
    }
}
