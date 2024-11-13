import java.util.HashSet;

// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
public class Video_52_Number_of_Good_Ways_to_Split_a_String {
    public int numSplits(String s) {
        int[] prefix = new int[s.length()];
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            set.add(ch);
            prefix[i++] = set.size();
        }
        set.clear();
        int[] suffix = new int[s.length()];
        for (int j = s.length() - 1; j >= 0; j--) {
            char ch = s.charAt(j);
            set.add(ch);
            suffix[j] = set.size();
        }
        int count = 0;
        for (int l = 0; l < suffix.length - 1; l++) {

            if (prefix[l] == suffix[l + 1])
                count++;
        }
//        System.out.println(Arrays.toString(prefix));
//        System.out.println(Arrays.toString(suffix));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Video_52_Number_of_Good_Ways_to_Split_a_String().numSplits("abcd"));
    }
}
