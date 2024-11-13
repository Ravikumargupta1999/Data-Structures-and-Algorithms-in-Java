package InterviewQuestion;

public class Video_98_Excel_Sheet_Column_Number {
    // https://leetcode.com/problems/excel-sheet-column-number/
    // https://www.youtube.com/watch?v=_NqvWkRN3Dc
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char ch : columnTitle.toCharArray()) {
            res *= 26;
            res += (ch - 'A' + 1);
        }
        return res;
    }
}
