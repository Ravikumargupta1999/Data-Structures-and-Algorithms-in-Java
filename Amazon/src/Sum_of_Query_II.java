import  java.util.*;
public class Sum_of_Query_II {
// https://practice.geeksforgeeks.org/problems/sum-of-query-ii5310/1/?category[]=Mathematical&category[]=Mathematical&company[]=Amazon&company[]=Amazon&page=3&query=category[]Mathematicalcompany[]Amazonpage3company[]Amazoncategory[]Mathematical

    static List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<queries.length;i+=2)
        {
            int sum = 0;
            for(int j = queries[i]-1;j<queries[i+1];j++)
            {
                sum += arr[j];
            }
            al.add(sum);
        }
        return al;

    }

    public static void main(String[] args) {
        int n = 4 ,arr[] = {1, 45, 13, 34,78,22,45,78} ,q = 3, queries[] = {1, 4, 2, 3,6,7};
        System.out.println(querySum(arr.length,arr,q,queries));
    }
}
