import java.util.ArrayList;
import java.util.HashMap;
//https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
public class A_Trie_2_2_Design_Add_and_Search_Words_Data_Structure_HashMap_Solution_Leetcode {
    HashMap<Integer, ArrayList<String>> map = new HashMap<>();

    public void addWord(String word) {
        ArrayList<String> al;
        if (map.get(word.length()) == null) {
            al = new ArrayList<>();

        } else {
           al = map.get(word.length());
        }

        al.add(word);
        map.put(word.length(), al);
    }

    public boolean search(String word) {
        if (map.get(word.length()) == null) {
            return false;
        }
        ArrayList<String> al = map.get(word.length());
        for (int i = 0; i < al.size(); i++) {
            String str = al.get(i);
            int j = 0;
            for (j = 0; j < str.length(); j++) {
                if (word.charAt(j) == '.')
                    continue;
                else if (str.charAt(j) != word.charAt(j))
                    break;
            }
            if (j == str.length())
                return true;
        }
        return false;

    }


}
