//import org.omg.Messaging.SYNC_WITH_TRANSPORT;
//https://www.youtube.com/watch?v=5vP0-g94xEA&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=20
//https://leetcode.com/problems/search-a-2d-matrix/
public class Search_in_a_sorted_2_D_Array {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {10, 18, 42}};
        searchInSorted2DArray(arr,28);
    }
    public static void searchInSorted2DArray(int[][] arr,int x)
    {
        int i=0;
        int j = arr[0].length-1;
        while (i < arr.length && j >=0)
        {
            if(arr[i][j] == x)
            {
                System.out.println(i+"  "+j);
                return;
            }
            else if(x < arr[i][j])
                j--;
            else
                i++;
        }
        System.out.println("Not Found");
    }
}
