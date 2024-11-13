//https://www.hackerrank.com/challenges/find-digits/problem

public class Find_Digits {
    // Write your code here
    public static int findDigits(int n) {
        int count = 0;
        int temp = n;
        while (temp > 0) {
            if (temp % 10 == 0) {
                temp = temp/10;
                continue;
            }
            int a = temp % 10;
            if(n % a == 0)
                count++;
            temp = temp/10;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(findDigits(1012));
    }
}
