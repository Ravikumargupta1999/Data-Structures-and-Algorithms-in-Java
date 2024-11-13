import java.util.ArrayList;

public class String_98_Recursively_print_all_sentences_that_can_be_formed_from_ist_of_word_lists {

    // https://www.codingninjas.com/codestudio/problems/ninja-and-sentences_1123512?leftPanelTab=1
    public static void createSentences(ArrayList<ArrayList<String>> arr, ArrayList<ArrayList<String>> ans) {
        solve(0, new ArrayList<>(), arr, ans);
    }

    public static void solve(int row, ArrayList<String> temp, ArrayList<ArrayList<String>> arr, ArrayList<ArrayList<String>> ans) {
        if (row == arr.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.get(row).size(); i++) {
            temp.add(arr.get(row).get(i));
            solve(row + 1, temp, arr, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
