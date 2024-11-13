//https://leetcode.com/problems/excel-sheet-column-number/submissions/

public class Excel_Sheet_Column_Number {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        int length = columnTitle.length()-1;
        for (char c : columnTitle.toCharArray()) {

            int d = c - 'A' + 1;
            result += ((int) Math.pow (26,length) * d);
//            System.out.println(c + "   " + d + "  " +  ((int) Math.pow (26,length) * d) +"   "+length);
            length--;

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BCD"));
    }
}
