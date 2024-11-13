import java.util.HashMap;

//
public class Decimal_To_Any_Base {
    public static void main(String[] args) {
        int val = '1' - 48;

        System.out.println(decimalToAnyBase(8, 2));
        System.out.println(getNumber(12,2833452));

    }
    //https://practice.geeksforgeeks.org/problems/decimal-to-any-base-conversion2440/1#
    static int decimalToAnyBase(int n, int b) {
        int ans = 0;
        int p = 1;
        while (n > 0) {
            int temp = n % b;
            n = n / b;
            ans += (temp * p);
            p = p * 10;
        }
        return ans;
    }

    static String getNumber(int base, int n) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        map.put(16, 'G');

        while (n > 0) {
            int temp = n % base;
            n = n / base;
//            System.out.println(temp);
            if(temp > 9)
                sb.insert(0,map.get(temp));
            else
                sb.insert(0,""+temp);
        }
        return sb.toString();

    }

}
