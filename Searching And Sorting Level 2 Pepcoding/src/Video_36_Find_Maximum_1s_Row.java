public class Video_36_Find_Maximum_1s_Row {
    //https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#Heaters
    int rowWithMax1s(int arr[][], int n, int m) {
        int ans = -1;
        int maxone = 0;
        for(int i=0;i<n;i++)
        {
            int temp = -1;
            int s = 0;
            int e = m-1;
            while (s <= e)
            {
                int mid = s + (e-s)/2;
                if(arr[i][mid] == 1) {
                    temp = mid;
                    e = mid-1;
                }
                else {
                    s = mid + 1;
                }
            }
            if( temp != -1)
                if(m-temp > maxone) {
                    maxone = m-temp;
                    ans = i;
                }
        }
        return ans;
    }
    // Method : 2
    int rowWithMax1s1(int arr[][], int n, int m) {

        int row = arr.length-1;
        int col = arr[0].length-1;
        for(int i= 0; i<=col;i++)
        {
            for(int j=0; j<= row;j++)
            {
                if(arr[j][i] == 1)
                    return j;
            }
        }
        return -1;
    }
}
