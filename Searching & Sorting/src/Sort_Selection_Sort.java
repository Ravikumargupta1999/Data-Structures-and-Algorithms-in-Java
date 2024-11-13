// https://practice.geeksforgeeks.org/problems/selection-sort/1/?category[]=Sorting&category[]=Sorting&page=2&query=category[]Sortingpage2category[]Sorting

public class Sort_Selection_Sort {
    int  select(int a[], int j)
    {
        if(j<0 || j>a.length)
            return -1;
        for(int i=0;i<a.length;i++)
            if(j == i)
                return a[i];
        return -1;

    }

    void selectionSort(int a[], int n)
    {
        for(int i=0;i <a.length-1 ;i++)
        {
            int min =i;
            for (int j=i+1;j<a.length;j++)
            {
                if(a[j] < a[min])
                {
                    min=j;
                }
            }
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
    }
}
