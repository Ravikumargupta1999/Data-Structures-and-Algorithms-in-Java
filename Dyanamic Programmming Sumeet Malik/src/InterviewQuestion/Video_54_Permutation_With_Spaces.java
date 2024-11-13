package InterviewQuestion;

import java.util.ArrayList;

public class Video_54_Permutation_With_Spaces {
    // https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1
    ArrayList<String> permutation(String S) {
        ArrayList<String> res = new ArrayList<>();
        getPermutationWithSpace(0, S, "", res);
        return res;
    }

    void getPermutationWithSpace(int index, String str, String res, ArrayList<String> list) {
        if (index == str.length() - 1) {
            list.add(res + "" + str.charAt(index));
            return;
        }
        getPermutationWithSpace(index + 1, str, res + str.charAt(index) + " ", list);
        getPermutationWithSpace(index + 1, str, res + str.charAt(index), list);
    }
}
