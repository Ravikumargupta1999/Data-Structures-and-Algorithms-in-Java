import java.util.Scanner;

public class Rank_of_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int zcount = 0;
        for (int i = 0; i < t; i++) {
            int[][] A = new int[3][3];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    A[j][k] = sc.nextInt();
                    if (A[j][k] == 0) {
                        zcount++;
                    }

                }

            }

            if (zcount == 9) {
                System.out.println(0);
            } else {
                int det = 0;
                int det2cnt = 0;
                det += A[0][0] * ((A[1][1] * A[2][2]) - (A[1][2] * A[2][1]));
                det += -1 * A[0][1] * ((A[1][0] * A[2][2]) - (A[1][2] * A[2][0]));
                det += A[0][2] * ((A[1][0] * A[2][1]) - (A[1][1] * A[2][0]));

                if ((A[0][0] * A[1][1]) - (A[0][1] * A[1][0]) == 0) {
                    det2cnt++;
                }
                if ((A[0][1] * A[1][2]) - (A[0][2] * A[1][1]) == 0) {
                    det2cnt++;
                }
                if ((A[0][0] * A[1][2]) - (A[0][2] * A[1][0]) == 0) {
                    det2cnt++;
                }
                if ((A[1][0] * A[2][1]) - (A[1][1] * A[2][0]) == 0) {
                    det2cnt++;
                }
                if ((A[1][1] * A[2][2]) - (A[1][2] * A[2][1]) == 0) {
                    det2cnt++;
                }
                if ((A[1][0] * A[2][2]) - (A[1][2] * A[2][0]) == 0) {
                    det2cnt++;
                }
                if ((A[2][0] * A[0][1]) - (A[2][1] * A[0][0]) == 0) {
                    det2cnt++;
                }
                if ((A[2][1] * A[0][2]) - (A[2][2] * A[0][1]) == 0) {
                    det2cnt++;
                }
                if ((A[2][0] * A[0][2]) - (A[2][2] * A[0][0]) == 0) {
                    det2cnt++;
                }
                if (det == 0) {
                    if (det2cnt == 9) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                } else {
                    System.out.println(3);
                }

            }
        }
    }
}
