import java.util.Arrays;

public class Merge_Without_Extra_Space {
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        int i= n-1;
        int j=0;
        while(i>=0 && j<m)
        {
            if(arr1[i]>=arr2[j])
            {
                long temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            }
            else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
