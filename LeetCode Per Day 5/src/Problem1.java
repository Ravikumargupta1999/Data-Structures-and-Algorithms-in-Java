import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if( n < 3 || n % 2 == 0)
            return;


        // First row

        for(int i = 0; i< n ;i++){
            System.out.print('*');
        }
        System.out.println();


        // Middle rows

        // Upper middle row

        int left = n/2;
        int right = n/2;
        while (left > 0 && right > 0){
            int leftStar = left;
            int rightStar = right;
            int space = n -(left+right);

            while (leftStar-- > 0){
                System.out.print('*');
            }
            while (space-- > 0){
                System.out.print(' ');
            }
            while (rightStar-- > 0){
                System.out.print('*');
            }
            System.out.println();
            left--;
            right--;
        }


        // lower middle rows;
        left = 2;
        right = 2;


        while (left <= n/2 && right <= n/2){
            int leftStar = left;
            int rightStar = right;
            int space = n -(left+right);

            while (leftStar-- > 0){
                System.out.print('*');
            }
            while (space-- > 0){
                System.out.print(' ');
            }
            while (rightStar-- > 0){
                System.out.print('*');
            }
            System.out.println();
            left++;
            right++;
        }


        // Last row

        for(int i = 0; i< n ;i++){
            System.out.print('*');
        }
        System.out.println();



    }
}
