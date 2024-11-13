import java.util.ArrayList;

public class String_65_Print_All_Possible_String {
    // https://practice.geeksforgeeks.org/problems/print-all-possible-strings/1


    ArrayList<String> spaceString(String str) {
        ArrayList<String> list = new ArrayList<>();
        printSubsequence(0, str, "", list);
        return list;
    }

    void printSubsequence(int index, String str, String asf, ArrayList<String> list) {
        if (index == str.length() - 1) {
            asf += str.charAt(index);
            list.add(asf);
            return;
        }
        printSubsequence(index + 1, str, asf + str.charAt(index), list);
        printSubsequence(index + 1, str, asf + str.charAt(index) + " ", list);

    }
}
