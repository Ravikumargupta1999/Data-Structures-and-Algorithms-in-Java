import java.util.ArrayList;
import java.util.List;

public class Palindrome_Pairs {
    public List<List<Integer>> palindromePairs(String[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isPalindriome(arr[i] + arr[j])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                if (isPalindriome(arr[j] + arr[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    ans.add(temp);

                }
            }
        }
        return ans;
    }

    static boolean isPalindriome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
