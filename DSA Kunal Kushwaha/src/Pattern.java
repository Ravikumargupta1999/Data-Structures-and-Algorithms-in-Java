import java.util.Scanner;

public class Pattern {
    public static void pattern32(int n)
    {
        int val = n;

        n = 2*n;
        for(int row = 1;row<n;row++)
        {
            for(int col = 1;col<n;col++)
            {
                int temp1 = Math.min(col,row);
                int temp2 = Math.min(n-row,n-col);
                int temp = Math.min(temp1,temp2);
                System.out.print((temp-1)+" ");

            }
            System.out.print("\n");
        }
    }
    public static void pattern31(int n)
    {
        int val = n;

        n = 2*n;
        for(int row = 1;row<n;row++)
        {
            for(int col = 1;col<n;col++)
            {
                int temp1 = Math.min(col,row);
                int temp2 = Math.min(n-row,n-col);
                int temp = Math.min(temp1,temp2);
                System.out.print((val-temp+1)+" ");

            }
            System.out.print("\n");
        }
    }
    public static void pattern30(int n)
    {
        for(int row = 1;row<=n;row++)
        {
            int totalSpace = n-row;
            for(int space = 1;space<=totalSpace;space++)
            {
                System.out.print("  ");
            }

            for(int col = row;col>=1;col--)
            {
                System.out.print(col+" ");
            }
            for(int col = 2;col<=row;col++)
            {
                System.out.print(col+" ");
            }
            System.out.print("\n");
        }
    }
    public static void pattern29(int n)
    {
        for(int row = n;row >= 1;row--)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int row = 2;row <= n;row++)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void pattern28(int n) {
        for (int row = 1; row <= (2 * n - 1); row++) {
            int noOfSpaces = row > n ? row - n : n - row;
            for (int space = 0; space < noOfSpaces; space++) {
                System.out.print(" ");
            }
            int totalColInRow = row > n ? (2 * n - row) : row;
            for (int col = 1; col <= totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");

        }
    }
    public static void pattern27(int n)
    {
        int temp2 = n*(n+1);
        int temp1= 1;
        for(int row = 1;row<=n;row++)
        {
            int totalSpace = row-1;
            for(int space = 1;space<=totalSpace;space++)
            {
                System.out.print("    ");
            }
            for(int col = 1;col<=n-row+1;col++)
            {
                if(temp1>=10)
                    System.out.print(temp1++ +"  ");
                else
                    System.out.print(temp1++ +"   ");
            }
            int temp = temp2-(n-row);
            for(int col =1 ;col<=n-row+1;col++)
            {
                if(temp>=10)
                    System.out.print(temp++ +"  ");
                else
                    System.out.print(temp++ +"   ");
            }
            temp2 = temp2 - (n-row+1);
            System.out.print("\n");
        }
    }
    public static void pattern26(int n)
    {
        int val = 1;

        for(int row = 1; row<= n ;row++)
        {
            for(int col = 1;col<= n-row +1;col++)
            {
                System.out.print(row+" ");
            }
            System.out.print("\n");

        }

    }
    public static void pattern25(int n)
    {
        for(int row=1 ;row<=n;row++)
        {
            int totalSpace =n-row;
            for(int space = 1;space<=totalSpace;space++)
            {
                System.out.print(" ");
            }
            for(int col=1;col<=n;col++)
            {
                if(col==1 || col == n || row == 1 || row == n )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    public static void pattern22(int n)
    {
        int val = 1;

        for(int row = 1; row<= n ;row++)
        {
            int temp = val;
            for(int col = 1;col<= row ;col++)
            {
                System.out.print(val+" ");
                if(val == 1)
                    val = 0;
                else
                    val = 1;
            }
            System.out.print("\n");
            if(temp == 1)
                val = 0;
            else
                val = 1;
        }

    }



    public static void pattern21(int n)
    {
        int val = 1;

        for(int row = 1; row<= n ;row++)
        {
            for(int col = 1;col<= row ;col++)
            {
                if(val>= 10)
                    System.out.print((val++) +" ");
                else
                    System.out.print((val++) +"  ");

            }
            System.out.print("\n");

        }

    }

    public static void pattern19(int n)
    {
        for(int row = n;row >= 1;row--)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int row = 2;row <= n;row++)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void pattern18(int n)
    {
        for(int row = 1;row <= n;row++)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        for(int row = n;row >= 1;row--)
        {
            int space = 2*(row-1);
            int star = 2*n - space;
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            for(int s = 1;s<=space;s++)
            {
                System.out.print(" ");
            }
            for(int col = 1;col<=star/2;col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void pattern17(int n)
    {
        for(int row = 1;row<=n;row++)
        {
            int totalSpace = n-row;
            for(int space = 1;space<=totalSpace;space++)
            {
                System.out.print(" ");
            }

            for(int col = row;col>=1;col--)
            {
                System.out.print(col);
            }
            for(int col = 2;col<=row;col++)
            {
                System.out.print(col);
            }
            System.out.print("\n");
        }
        for(int row = n-1;row>=1;row--)
        {
            int totalSpace = n-row;
            for(int space = 1;space<=totalSpace;space++)
            {
                System.out.print(" ");
            }

            for(int col = row;col>=1;col--)
            {
                System.out.print(col);
            }
            for(int col = 2;col<=row;col++)
            {
                System.out.print(col);
            }
            System.out.print("\n");
        }
    }

    public static void pattern15(int n)
    {
        for (int row = 1; row <= n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                if(col == 1 || col == row)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
        for (int row = 2; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (n-row)+1;
            for (int col = 1; col <= totalColumn; col++) {
                if(col == 1 || col == totalColumn)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
    public static void pattern14(int n)
    {
        for(int i=1;i<=2*n-1;i++)
        {
            System.out.print("*");
        }
        System.out.print("\n");
        for (int row = 2; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (n-row)+1;
            for (int col = 1; col <= totalColumn; col++) {
                if(col == 1 || col == totalColumn)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
    public static void pattern13(int  n)
    {
        for (int row = 1; row < n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (row);
            for (int col = 1; col <= totalColumn; col++) {
                if(col == 1 || col == totalColumn)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
        for(int i=1;i<=2*n-1;i++)
        {
            System.out.print("*");
        }
    }
    public static void pattern12(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (n-row)+1;
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        for (int row = 1; row <= n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (row);
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
    public static void pattern11(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (n-row)+1;
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    public static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print(" ");
            }
            int totalColumn = (row);
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern9(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print("  ");
            }
            int totalColumn = 2 * (n- row) + 1;
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    public static void pattern8(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print("  ");
            }
            int totalColumn = (2 * row - 1);
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = row - 1;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print("  ");
            }
            int totalColumn = n - row + 1;
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpace = n - row;
            for (int space = 1; space <= totalSpace; space++) {
                System.out.print("  ");
            }
            int totalColumn = row;
            for (int col = 1; col <= totalColumn; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern5(int n) {


        for (int row = 1; row <= (2 * n - 1); row++) {
            int totalColInRow = row > n ? (2 * n - row) : row;
            for (int col = 1; col <= totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("  Pattern 1      \n");
        pattern1(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 2      \n");
        pattern2(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 3      \n");
        pattern3(n);
        System.out.println("\n\n");


        System.out.println("  Pattern 4      \n");
        pattern4(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 5      \n");
        pattern5(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 6      \n");
        pattern6(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 7      \n");
        pattern7(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 8      \n");
        pattern8(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 9      \n");
        pattern9(n);
        System.out.println("\n\n");

        System.out.println("   Pattern 10      \n");
        pattern10(n);
        System.out.println("\n\n");

        System.out.println("   Pattern 11      \n");
        pattern11(n);
        System.out.println("\n\n");

        System.out.println("   Pattern 12      \n");
        pattern12(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 13      \n");
        pattern13(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 14      \n");
        pattern14(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 15      \n");
        pattern15(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 17     \n");
        pattern17(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 18     \n");
        pattern18(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 19     \n");
        pattern19(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 21     \n");
        pattern21(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 22     \n");
        pattern22(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 25     \n");
        pattern25(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 26     \n");
        pattern26(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 27     \n");
        pattern27(n);
        System.out.println("\n\n");


        System.out.println("  Pattern 28      \n");
        pattern28(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 29     \n");
        pattern29(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 30     \n");
        pattern30(n);
        System.out.println("\n\n");

        System.out.println("  Pattern 31     \n");
        pattern31(n);
        System.out.println("\n\n");


        System.out.println("  Pattern 32     \n");
        pattern32(n);
        System.out.println("\n\n");


    }
}
