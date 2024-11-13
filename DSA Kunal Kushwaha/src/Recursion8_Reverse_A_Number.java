public class Recursion8_Reverse_A_Number {
    public static void main(String[] args) {
        System.out.println(reverse(200, 0));
    }
//https://practice.geeksforgeeks.org/problems/reverse-digit0316/1
    public static int reverse(int n, int num) {
        if (n == 0)
            return num;
        num = num * 10 + n % 10;
        return reverse(n / 10, num);
    }
}
