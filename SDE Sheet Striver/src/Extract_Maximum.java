public class Extract_Maximum {
    // https://practice.geeksforgeeks.org/problems/extract-maximum2943/1?page=23&company[]=Amazon&sortBy=submissions
    static int extractMaximum(String S) {
        int maximum = 0;
        int num = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {

                int val = Character.getNumericValue(ch);
                num = num * 10 + val;
                maximum = Math.max(maximum, num);
            } else {
                num = 0;
            }
        }
        return maximum;
    }
}
