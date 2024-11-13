// https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/?category[]=Arrays&category[]=Arrays&page=1&query=category[]Arrayspage1category[]Arrays

public class Wave_Array {

    public static void convertToWave(int arr[], int n){
        for(int i=0;i<n;i+=2)
        {
            if(i == n-1)
                continue;
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
}
