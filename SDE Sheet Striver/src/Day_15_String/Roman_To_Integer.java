package Day_15_String;

import java.util.HashMap;

public class Roman_To_Integer {
    //    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == 'I' && i != s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                res += (map.get(s.charAt(i + 1)) - map.get(ch));
                i++;
            } else if (ch == 'X' && i != s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                res += (map.get(s.charAt(i + 1)) - map.get(ch));
                i++;
            } else if (ch == 'C' && i != s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                res += (map.get(s.charAt(i + 1)) - map.get(ch));
                i++;
            } else {
                res += map.get(ch);
            }
        }
        return res;
    }

    // https://leetcode.com/problems/integer-to-roman/submissions/
    public String intToRoman(int num) {
        int[] incode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strCode = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
//        System.out.println(incode.length);
//        System.out.println(strCode.length);
        for (int i = 0; i < incode.length; i++) {
            while (num >= incode[i]) {
                num -= incode[i];
                sb.append(strCode[i]);
            }
        }
        return sb.toString();

    }
}