import com.sun.deploy.security.SelectableSecurityManager;

import java.util.HashMap;
import java.util.HashSet;

public class Remove_duplicate {
    String removeDuplicates(String str) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++)
            set.add(str.charAt(i));
        String temp  = "";
        for (int i=0;i<str.length();i++) {
            if (set.contains(str.charAt(i))) {
                temp = temp + str.charAt(i);
                set.remove(str.charAt(i));
            }

        }
        return temp;
    }
}
