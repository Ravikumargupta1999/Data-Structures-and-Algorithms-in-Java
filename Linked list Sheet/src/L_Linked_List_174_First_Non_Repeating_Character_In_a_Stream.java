import java.util.ArrayList;

public class L_Linked_List_174_First_Non_Repeating_Character_In_a_Stream {
    // https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
    //    First non-repeating character in a stream
    public String FirstNonRepeating(String A) {
        ArrayList<Character> order = new ArrayList<>();
        int[] count = new int[26];
        StringBuilder result = new StringBuilder("");
        for (char ch : A.toCharArray()) {

            if (count[ch - 'a'] == 0)
                order.add(ch);
            count[ch - 'a']++;

            int j = 0;
            while (j < order.size()) {
                if (count[order.get(j) - 'a'] < 2) {
                    result.append(order.get(j));
                    break;
                }
                j++;
            }
            if (j == order.size())
                result.append('#');
        }
        return result.toString();
    }
}
