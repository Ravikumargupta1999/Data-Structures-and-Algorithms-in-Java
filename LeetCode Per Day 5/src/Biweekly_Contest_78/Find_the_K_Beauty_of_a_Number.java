package Biweekly_Contest_78;

public class Find_the_K_Beauty_of_a_Number {
    public static void main(String[] args) {
        int n1 = 430043;
        int k = 2;
        System.out.println(divisorSubstrings(n1, k));
    }

    public static int divisorSubstrings(int num, int k) {
        String s1 = Integer.toString(num);
        int count = 0;
        for (int i = 0; i < s1.length() - k + 1; i++) {
            int n1 = Integer.parseInt(s1.substring(i, i+k));
            System.out.println(n1);
            if(n1 == 0)
                continue;
            if (num % n1 == 0)
                count++;
        }
        return count;
    }
}
