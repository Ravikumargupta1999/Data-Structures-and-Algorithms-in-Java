public class Search_In_2D_Array {
    static int search(int[][] arr,int target)
    {
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                if(arr[i][j] == target)
                    return 1;
        return 0;
    }
    public static void main(String[] args) {
        int[][] arr= {
                {3,4,5,7,8},
                {45,2,1,5,7,8},
                {10,96,3,13}
        };
        System.out.println(search(arr,45));
    }
}
