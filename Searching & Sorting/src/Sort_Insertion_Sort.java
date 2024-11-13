public class Sort_Insertion_Sort {
    public void insertionSort(int a[], int n)
    {
        for(int i=1;i < a.length ;i++)
        {
            int  key = a[i];
            int j=i-1;
            while (j>=0 && a[j]>key)
            {
                a[j+1]=a[j];
                j=j-1;
            }
            a[j+1]=key;
        }
    }
}
