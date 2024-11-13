package InterviewQuestion;

public class Video_43_Count_Number_Of_Words {
    // https://practice.geeksforgeeks.org/problems/count-number-of-words1500/1
    static int countWords(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                count++;
            else if (!Character.isLowerCase(ch)) {

                i++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "a\\nhjpfo";
        System.out.println(countWords(str));
    }
}
