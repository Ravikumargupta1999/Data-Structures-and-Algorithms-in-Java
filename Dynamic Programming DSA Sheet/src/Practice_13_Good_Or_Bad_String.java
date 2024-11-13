import java.util.HashSet;

public class Practice_13_Good_Or_Bad_String {
    static int isGoodorBad(String S) {
        int consonent = 0;
        int vowel = 0;

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (char ch : S.toCharArray()) {
            if (set.contains(ch))
                vowel++;
            else if (ch == '?'){
                if(consonent < 3)
                    consonent++;
                else
                    vowel++;
            }

            else
                consonent++;
        }
//        System.out.println(consonent + "    " + vowel);
        boolean val = consonent <= 3 && vowel <= 5;
//        System.out.println(val);
        return val ? 1 : 0;

    }

    public static void main(String[] args) {
        String str = "?c?a";
        System.out.println(isGoodorBad(str));
    }
}
