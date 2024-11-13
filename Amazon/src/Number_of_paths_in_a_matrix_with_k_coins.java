//https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Backtracking&query=company[]Amazonpage1company[]Amazoncategory[]Backtracking#

public class Number_of_paths_in_a_matrix_with_k_coins {
    static long numberOfPath(int n, int k, int [][]arr) {
        if( n == 1){
            if(  k == arr[0][0])
                return 1;
            return 0;
        }
        System.out.println(n+"  "+k);
        long a = findTotalWays(n,k-arr[0][0],0,1,arr);
        long b = findTotalWays(n,k-arr[0][0],1,0,arr);
        return a + b;
    }
    static long findTotalWays(int n,int k,int row,int col,int[][] arr)
    {
        if( col >= n || row >= n)
            return 0;
        if( row == n-1 && col == n-1)
        {
            System.out.println(n+"  Helllo  "+k+"  "+arr[row][col]);
            if(  k == arr[row][col])
                return 1;
            return 0;
        }
        long ans = 0;
        ans += findTotalWays(n,k-arr[row][col],row+1,col,arr);
        ans += findTotalWays(n,k-arr[row][col],row,col+1,arr);
        return ans;
    }

    public static void main(String[] args) {
        int k = 5, n = 3;
        int arr[][] = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        System.out.println(numberOfPath(n,k,arr));
    }
}
