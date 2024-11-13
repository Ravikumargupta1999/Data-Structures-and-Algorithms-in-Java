import java.util.ArrayList;
import java.util.List;

public class Video_41_Palindrome_Partitioning_of_a_String {
    public void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            System.out.println(i + 1 + "    " + str.length());
            if (isPalindrome(prefix)) {
                solution(ros, asf + "(" + prefix + ") ");
            }
        }

    }


    public static void main(String[] args) {
        String str = "aba";
        System.out.println(new Video_41_Palindrome_Partitioning_of_a_String().partition(str));
    }

    // https://leetcode.com/problems/palindrome-partitioning/submissions/
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        findSolution(s, temp, list);
        return list;

    }

    void findSolution(String str, List<String> temp, List<List<String>> list) {
        if (str.length() == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);
            temp.add(left);
            if (isPalindrome(left)) {
                findSolution(right, temp, list);
            }
            temp.remove(temp.size() - 1);
        }
    }

    boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
