package InterviewQuestion;

public class Video_97_Excel_Sheet_Column_Title {
    // https://leetcode.com/problems/excel-sheet-column-title/
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder("");
        while (columnNumber > 0) {

            int rem = columnNumber % 26;
            rem = rem == 0 ? 26 : rem;
            char ch =  ((char) ('A' + rem-1));
            columnNumber -= rem;
            columnNumber = columnNumber / 26;

            sb.insert(0,ch);
        }
        return sb.toString();
    }
    // https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1
    String colName (long n)
    {
        StringBuilder sb = new StringBuilder("");
        while (n > 0) {

            long rem = n % 26;
            rem = rem == 0 ? 26 : rem;
            char ch =  ((char) ('A' + rem-1));
            n -= rem;
            n = n / 26;

            sb.insert(0,ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Video_97_Excel_Sheet_Column_Title().convertToTitle(701));
    }
}
