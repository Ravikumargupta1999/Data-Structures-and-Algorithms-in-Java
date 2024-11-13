public class Saddle_Point {
 //https://www.geeksforgeeks.org/saddle-point-matrix/
 //https://www.youtube.com/watch?v=6YIWq2JGzEQ&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=18
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {10, 18, 4}};
        saddlePoint(arr);
    }
    public static void saddlePoint(int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int svj =0;
            for(int j=1;j<arr.length;j++)
            {
                if(arr[i][j] < arr[i][svj])
                    svj = j;
            }
//            System.out.println(arr[i][svj]);
            boolean flag = true;
            for(int k=0;k<arr.length;k++)
            {
                if(arr[k][svj] > arr[i][svj])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println(arr[i][svj]);
                return;
            }
        }
        System.out.println("No saddle point");
    }
}
