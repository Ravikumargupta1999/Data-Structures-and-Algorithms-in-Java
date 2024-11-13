package Day1;

import java.util.List;

public class Simple_Array_Sum {
    //https://www.hackerrank.com/challenges/simple-array-sum/problem
    public static int simpleArraySum(List<Integer> arr) {
        // Write your code here

        int sum = 0;
        for(int ele :arr){
            sum += ele;
        }
        return sum;
    }
}
