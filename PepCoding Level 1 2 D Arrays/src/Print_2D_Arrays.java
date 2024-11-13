public class Print_2D_Arrays {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 } };
        System.out.println("Traversing Row Wise : ");
        for(int i=0;i<arr.length;i++)
        {
            for (int j=0;j < arr[0].length;j++)
            {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.print("\n\n\n");
        System.out.println("Traversing Column Wise : ");
        for(int i=0;i<arr[0].length;i++)
        {
            for (int j=0;j < arr.length;j++)
            {
                System.out.print(arr[j][i]+"  ");
            }
            System.out.println("");
        }
    }
}
