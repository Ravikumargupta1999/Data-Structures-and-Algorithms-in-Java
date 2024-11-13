public class Sort_Bubble_Sort {
    public static void bubbleSort(int a[], int n)
    {
        for(int i=0;i <a.length ;i++)
        {
            for (int j=0;j<a.length-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
