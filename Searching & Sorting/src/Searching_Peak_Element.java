// https://practice.geeksforgeeks.org/problems/peak-element/1/?category[]=Searching&category[]=Searching&page=1&query=category[]Searchingpage1category[]Searching#
public class Searching_Peak_Element {
    public int peakElement(int[] arr,int n)
    {
        if(n == 1)
            return 0;
        for(int i=0;i<n;i++)
        {
            if(i == 0)
            {
                if(arr[i]>arr[i+1])
                    return i;
            }
            else if(i == n-1)
            {
                if(arr[i]>arr[i-1])
                    return i;
            }
            else if(arr[i]>arr[i-1] && arr[i+1]<arr[i])
                return i;

        }
        return -1;
    }
}
