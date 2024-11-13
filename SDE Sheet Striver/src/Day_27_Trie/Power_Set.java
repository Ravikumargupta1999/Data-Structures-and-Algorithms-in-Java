package Day_27_Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Power_Set {
    public List<String> AllPossibleStrings(String s) {
        int n = s.length();

        List<String> list = new ArrayList<>();
        for (int num = 0; num < ((1 << n)); num++) {
            String temp = "";
            for (int i = 0; i < n; i++) {

                if ((num & (1 << i)) != 0) {
                    temp += s.charAt(i);
                }
            }
            if (temp.length() != 0)
                list.add(temp);
        }
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            }
            return a.length() - b.length();
        });
        return list;
    }
}
