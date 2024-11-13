

// Done
public class String_65_Sum_of_All_Subsequences_Of_A_Number {
    // https://practice.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1/
    int subsequenceSum(String s) {
        int sum = 0;
        for (char ch : s.toCharArray())
            sum += (Character.getNumericValue(ch)*Math.pow(2,s.length()-1));
        return sum;
    }
}
