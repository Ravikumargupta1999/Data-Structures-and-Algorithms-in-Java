import java.util.HashSet;
// https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/
public class Reverse_Vowels_of_a_String {
    public static String reverseVowels(String s) {
        StringBuilder st = new StringBuilder();
        st.append(s);
        int i= 0;
        int j = st.length()-1;

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
//        int count = 0;
        while (i<j )
        {
            char ch1 = st.charAt(i);
            char ch2 = st.charAt(j);
            if(set.contains(ch1) && set.contains(ch2)) {
//                System.out.println(st+"  "+i+"  "+j);

                st.replace(i,i+1,ch2+"");
                st.replace(j, j+1,ch1+"");
                i++;
                j--;

            }
            else if(set.contains(ch1))
                j--;
            else if(set.contains(ch2))
                i++;
            else
            {
                i++;
                j--;
            }
//            System.out.println(st+"  hello  "+ i+"  "+j);
//            count++;
        }
        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

}
