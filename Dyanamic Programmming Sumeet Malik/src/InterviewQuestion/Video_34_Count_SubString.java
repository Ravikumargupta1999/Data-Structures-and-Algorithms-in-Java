package InterviewQuestion;

public class Video_34_Count_SubString {
    int countSubstr(String S) {
        int count = 0;
        int res = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '1') {
                count++;
                res += (count - 1);
            }
        }
        return res;
    }
}
