public class Total_Count {
    int totalCount(int[] a, int n, int m) {
        int sum =0;
       for(int i=0;i<n;i++)
       {
           if(a[i]%m>0)
           {
               sum=sum+1;
           }
           sum=sum+a[i]/m;
       }
       return sum;
    }
}
//http://suganyamurali.blogspot.com/2016/07/given-array-and-threshold-value-k-where.html
// https://practice.geeksforgeeks.org/problems/total-count2415/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-1&page=1&query=category[]Arraysdifficulty[]-1page1category[]Arrays
