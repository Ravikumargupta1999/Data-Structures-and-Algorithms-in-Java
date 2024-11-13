import java.util.HashMap;

public class String_81_Roman_To_Decimal {
    // https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1
    public static int Roman_to_String(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1 && hashMap.get(str.charAt(i)) < hashMap.get(str.charAt(i + 1))) {
                sum += hashMap.get(str.charAt(i + 1)) - hashMap.get(str.charAt(i));
                i++;
            } else {
                sum += hashMap.get(str.charAt(i));
            }
        }
        return sum;
    }
}
