import java.util.HashSet;

public class Video_34_Print_in_Lexicographical_Order_String {
    // https://www.geeksforgeeks.org/print-all-the-combinations-of-a-string-in-lexicographical-order/
    public static void main(String[] args) {
        String str = "ABC";
        char[] chars = new char[26];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'A';
            chars[val]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chars[i]; i++) {
                sb.append((char) ('A' + i));
            }

        }
//        System.out.println(temp);

        HashSet<Character> set = new HashSet<>();
        printLexicographical(sb.toString(), set, "");
    }

    public static void printLexicographical(String str, HashSet<Character> set, String asf) {
        if (asf.length() > str.length()) {
//            System.out.println(asf);
            return;
        }
        System.out.println(asf);

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                printLexicographical(str, set, asf + str.charAt(i));
                set.remove(str.charAt(i));
            }
        }
    }

}
