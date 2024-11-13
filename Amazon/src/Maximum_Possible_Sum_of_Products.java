import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/maximum-possible-sum-of-products3637/1/?category[]=Mathematical&category[]=Mathematical&company[]=Amazon&company[]=Amazon&page=3&query=category[]Mathematicalcompany[]Amazonpage3company[]Amazoncategory[]Mathematical

public class Maximum_Possible_Sum_of_Products {

    long MaxSum(long []a, long []b, int n)
    {
        long ans = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i =0;i<n;i++)
            ans += (a[i]*b[i]);
        return ans;
    }
}
