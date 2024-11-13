package InterviewQuestion;

public class Video_56_Remove_b_and_ac_from_a_given_string {
    // https://practice.geeksforgeeks.org/problems/remove-b-and-ac-from-a-given-string4336/1
    public static String stringFilter(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'b')
                continue;
            else if (str.charAt(i) == 'a' && (i + 1) < str.length() && str.charAt(i + 1) == 'c') {
                i++;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringFilter("aacb"));
    }
}
