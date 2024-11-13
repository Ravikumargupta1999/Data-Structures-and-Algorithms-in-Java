import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if( n < 3 || n % 2 == 0)
            return;
        int leftStart = 1;

        while (leftStart < (n/2 +1)){
            int temp = leftStart;
            while (temp-->0){
                System.out.print('*');
            }
            System.out.println();
            leftStart++;
        }


        int space = 0;
        while (space <= (n/2+1)){
            int star = (n/2+1)-space;

            int temp1 = space;
            while (temp1-- > 0){
                System.out.print(' ');
            }
            int temp2 = star;
            while (temp2-- > 0){
                System.out.print('*');
            }
            System.out.println();
            space++;
        }
    }
}
