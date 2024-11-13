// https://practice.geeksforgeeks.org/problems/maximum-in-struct-array/1/?category[]=Arrays&category[]=Arrays&page=2&query=category[]Arrayspage2category[]Arrays#

public class Maximum_in_Struct_Array {
    static class Height {
        int feet;
        int inches;
        public Height(int ft, int inc)
        {
            feet = ft;
            inches = inc;
        }
    }
    public static int findMax(Height arr[], int n)
    {
        for(int i=0;i<n;i++)
        {
            arr[i].feet = 12*arr[i].feet;
        }
        int max = arr[0].feet + arr[0].inches;
        for(int i=1;i<n;i++)
        {
            int sum = arr[i].feet + arr[i].inches;
            if(max < sum)
                max = sum;
        }
        return max;
    }
}
