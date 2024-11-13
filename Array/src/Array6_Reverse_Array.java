import java.util.Arrays;
import java.util.Scanner;

// Done
public class Array6_Reverse_Array {


    public static void reverse(int[] arr) {
        int mid = arr.length;
        int end = arr.length - 1;
        for (int i = 0; i < mid; i++) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            end--;

        }
    }

    // https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/#

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "i.like.this.program.very.much";
        String reverse = ReverseString(str);
        System.out.println(reverse);

    }

    public static String ReverseStringApproach1(String str) {
        System.out.println(str);
        String[] arr = str.split(".");
        System.out.println(Arrays.toString(arr));
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(res + "  " + arr[i]);
            if (i != 0) {
                res += arr[i] + ".";
            } else {
                res += arr[i];
            }
        }
        return res;
    }

    public static String ReverseString(String str) {
        StringBuilder temp = new StringBuilder("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                temp.append(str.charAt(i));
            } else {
                sb.insert(0, temp);
                sb.insert(0, ".");
                temp = new StringBuilder("");
            }
        }
        sb.insert(0, temp);
        return sb.toString();
    }
}
