public class String_83_Min_Number_of_Flips {
    // https://www.youtube.com/watch?v=F0E7k6X_kt8
    // https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1
    public static int minSwaps(String str) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 != 0 && str.charAt(i) == '0')
                c1++;
            if (i % 2 == 0 && str.charAt(i) == '1')
                c1++;
            if (i % 2 != 0 && str.charAt(i) == '1')
                c2++;
            if (i % 2 == 0 && str.charAt(i) == '0')
                c2++;
        }
        return Math.min(c1, c2);
    }

    public static void main(String[] args) {
        int value = minSwaps("");
        System.out.println(value);

    }
}
