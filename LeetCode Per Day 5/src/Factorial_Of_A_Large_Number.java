import java.util.ArrayList;
import java.util.Collections;

public class Factorial_Of_A_Large_Number {
    //https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
    public static void main(String[] args) {
        ArrayList<Integer> list = factorial(10);
        int sum = 0;
        for (int val : list)
            sum += val;
        System.out.println(sum);
    }

    static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 2; i <= n; i++) {
            multiply(i, res);
        }
        Collections.reverse(res);
        return res;
    }

    static void multiply(int x, ArrayList<Integer> list) {
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int prod = x * list.get(i);
            prod += carry;
            list.set(i, prod % 10);
            carry = prod / 10;
        }
        while (carry != 0) {
            list.add(carry % 10);
            carry = carry / 10;
        }
    }
}
