import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class String_66_Recursion {
    // https://www.youtube.com/watch?v=sPAT_DbvDj0
    List<String> list = new ArrayList<>();
    public List<String> find_permutation(String str) {
        printPermutation(str, "");
        Collections.sort(list);
        return list;
    }

    public void printPermutation(String str, String asf) {
        if (str.length() == 0) {
            list.add(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String qlpart = str.substring(0, i);
            String qrpart = str.substring(i + 1);
            String rop = qlpart + qrpart;
            printPermutation(rop, asf + ch);
        }
    }
}
