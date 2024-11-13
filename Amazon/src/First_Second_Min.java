// https://practice.geeksforgeeks.org/problems/find-the-smallest-and-second-smallest-element-in-an-array3226/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=8&query=category[]Arrayscompany[]Amazonpage8company[]Amazoncategory[]Arrays#

public class First_Second_Min {
    public static  long[] minAnd2ndMin(long a[], long n)
    {
        long index = -1;
        long min = Long.MAX_VALUE;
        for(long l =0;l<n;l++) {
            if (a[(int) l] < min) {
                index = l;
                min = a[(int) l];
            }
        }
        long[] arr = new long[2];
        arr[0] = min;
        min = Long.MAX_VALUE;

        for(long l =0;l<n;l++)
            if(a[(int)l]> arr[(int)0] && a[(int)l] <= min && a[(int)l] != arr[0])
                min = a[(int)l];
        if(min == Long.MAX_VALUE)
        {
            arr[0] = -1;
            arr[1] = -1;
        }
        else
        {
            arr[1] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        long[] arr = {1,1,1,1};
        long[] res = minAnd2ndMin(arr,arr.length);
        if(res[0] == -1)
            System.out.println(res[0]);
        else
            System.out.print(res[0]+"  "+res[1]);
    }
}
