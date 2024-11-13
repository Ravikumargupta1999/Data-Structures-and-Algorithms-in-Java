import java.util.HashMap;

public class Any_Base_To_Decimal {
    public static void main(String[] args) {
        System.out.println(anyBaseToDecimal(1100,2));
        System.out.println(decimalEquivalent("5523BB",14));
    }
    static int anyBaseToDecimal(int n,int b)
    {
        int ans = 0;
        int p = 1;
        while (n > 0)
        {
            int temp = n % 10;
            n = n/10;
            ans = ans + (temp * p);
            p = p * b;
        }
        return ans;
    }
    //https://practice.geeksforgeeks.org/problems/convert-from-any-base-to-decimal3736/1
    static int decimalEquivalent(String str, int b) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        int p = 1;
        int ans = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            int val;
            if (map.containsKey(str.charAt(i)))
                val = map.get(str.charAt(i));
            else
                val = str.charAt(i) - 48;

            ans += (val * p);
            p = p * b;
//            System.out.println(val+"   "+ans);
        }
        return ans;
    }
}
