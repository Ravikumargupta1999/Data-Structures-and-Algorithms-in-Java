// https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1/?category[]=Arrays&category[]=Arrays&page=2&query=category[]Arrayspage2category[]Arrays
// greedy notes ke last page par khud ka logic hai betichod
public class Segregrate_0_and_1 {
    static void segregate0and1(int[] arr, int n) {
        int i = n-1;
        for(;i>=0;i--)
        {
            if(arr[i] == 0)
                break;
            else
                continue;
        }
        for(int j = i-1;j>=0;j--)
        {
            if(arr[j] == 1)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,0,1,0,0};

    }
}
