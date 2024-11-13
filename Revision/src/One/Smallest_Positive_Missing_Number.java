package One;

public class Smallest_Positive_Missing_Number {
    // https://www.youtube.com/watch?v=-lfHWWMmXXM
    static int missingNumber(int arr[], int size)
    {
        for(int i=0;i<size;i++)
        {
            int val = arr[i]-1;
            while ( 1 <= arr[i] && arr[i]  <= size && arr[i] != arr[val])
            {
                int temp = arr[val];
                arr[val]  = arr[i];
                arr[i] = temp;
                val = arr[i]-1;
            }
//            for(int j =0;j<size;j++)
//                System.out.print(arr[j]+"  ");
//            System.out.println("");
        }
        for(int i=0;i<size;i++)
        {
            if(i + 1 != arr[i])
                return i+1;
        }
        return size+1;
    }
}
