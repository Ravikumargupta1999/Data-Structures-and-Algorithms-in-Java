import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/at-least-two-greater-elements4625/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-2&page=1&query=company[]Amazondifficulty[]-2page1company[]Amazon

public class At_least_two_greater_element {
    public long[] findElements( long a[], long n)
    {
        if(n <=2)
            return new long[0];
        long[] result = new long[(int) n-2];

        Arrays.sort(a);
        for(long i=0;i < result.length;i++)
            result[(int) i] = a[(int)i];
        return result;

    }
}
