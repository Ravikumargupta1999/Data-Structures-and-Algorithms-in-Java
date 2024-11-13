public class Excel_Sheet_Column_Title {
    // https://leetcode.com/problems/excel-sheet-column-title/
    //https://practice.geeksforgeeks.org/problems/excel-sheet5448/1
    
    public static String convertToTitle(int n) {
        String result = "";
        while (n != 0) {
            int val = n % 26;
            char ch = (char) ('A' + (n - 1) % 26);
            result = ch + result;
            n = (n - 1) / 26;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(51));
    }
}
