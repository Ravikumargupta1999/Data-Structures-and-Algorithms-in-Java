import java.util.ArrayList;

//https://www.youtube.com/watch?v=SVFXEqn3Ceo&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=7
public class Spiral_Traversal {
    // https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
    public static void main(String[] args) {
        int[][] arr = new int[4][5];
        int k = 11;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = k++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.print("\n");
        }
        spiralTraversal(arr);
    }
    // https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
    static ArrayList<Integer> spirallyTraverse(int arr[][], int n, int m)
    {
        ArrayList<Integer> value=new ArrayList<>();
        int minr = 0;
        int minc = 0;
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        int total = n*m;
        int count = 0;
        while (count < total)
        {
            for(int i = minr,j = minc; j<=maxc && count<total; j++)
            {
                //  System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            minr++;
            for(int i = minr,j = maxc; i<=maxr && count<total; i++)
            {
                //System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            maxc--;
            for(int i = maxr,j = maxc; j>=minc && count<total; j--)
            {
                // System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            maxr--;
            for(int i = maxr,j = minc; i>=minr && count<total; i--)
            {
                // System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            minc++;
        }
        return value;
    }

    static void spiralTraversal(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int count = 0;
        int total = (arr.length)*(arr[0].length);
        while (count < total)
        {
            for(int i=minr, j = minc ;i<=maxr && count < total;i++)
            {
                System.out.print(arr[i][j]+"   ");
                count++;
            }
            minc++;
            for(int i=maxr, j = minc ;j<=maxc && count < total;j++)
            {
                System.out.print(arr[i][j]+"   ");
                count++;
            }
            maxr--;
            for(int i=maxr, j = maxc ;i >= minr && count < total;i--)
            {
                System.out.print(arr[i][j]+"   ");
                count++;
            }
            maxc--;
            for(int i=minr, j = maxc ;j>= minc && count < total;j--)
            {
                System.out.print(arr[i][j]+"   ");
                count++;
            }
            minr++;
        }
    }

}
