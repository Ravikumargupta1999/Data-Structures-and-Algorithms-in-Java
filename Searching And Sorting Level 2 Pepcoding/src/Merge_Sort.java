public class Merge_Sort {
    // https://practice.geeksforgeeks.org/problems/merge-sort/1
    void mergeSort(int arr[], int l, int r)
    {
        MergeSort(arr);
    }
    public   void MergeSort(int[] A)
    {
        int n= A.length;
        if(n<2)
            return;
        int mid=n/2;
        int[] left=new int[mid];
        int[] right=new int[n-mid];
        for(int i=0;i<mid;i++)
        {
            left[i]=A[i];
        }
        for(int i=mid;i<n;i++)
        {
            right[i-mid]=A[i];
        }
        MergeSort(left);
        MergeSort(right);
        Merge(left,right,A);
    }
    public  void Merge(int[] L,int[] R,int[] A)
    {
        int nL=L.length;
        int nR=R.length;
        int i=0;
        int j=0;
        int k=0;
        while (i<nL &&j<nR)
        {
            if (L[i]<=R[j])
            {
                A[k]=L[i];
                i+=1;
            }
            else
            {
                A[k]=R[j];
                j+=1;
            }
            k+=1;
        }
        while (i<nL)
        {
            A[k]=L[i];
            i+=1;
            k+=1;
        }
        while (j<nR)
        {
            A[k]=R[j];
            j+=1;
            k+=1;
        }

    }


    public static void main(String[] args) {
        int[] arr = {8,5,3,4,1,6,2};
        for(int a : arr)
            System.out.print(a+"  ");
        System.out.println("\n");
        Merge_Sort  a = new Merge_Sort();
        a.mergeSort(arr,0,arr.length);
        for(int a1 : arr)
            System.out.print(a1+"  ");
        System.out.println("\n");
    }
}