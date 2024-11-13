public class Leet_Code_1422_Maximum_Score_After_Splitting_a_String {
    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                ones++;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zeros++;
            if (s.charAt(i) == '1')
                ones--;
            max = Math.max(max, ones + zeros);
        }
        return max;
    }
}
