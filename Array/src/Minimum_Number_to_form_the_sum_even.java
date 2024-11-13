public class Minimum_Number_to_form_the_sum_even {

    long minNum(long arr[], int n)
    {
        long sum=0;
       for(int i=0;i<n;i++)
           sum += arr[i];
       if(sum %2 ==0)
           return 2;
       else
           return 1;

    }
    public static void main(String[] args) {

    }
}
