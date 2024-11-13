import java.util.Arrays;
import java.util.Scanner;

public class Searching_Sorting_119_Bis_h_u_and_Soldiers {
    // https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] powerOfSoldier = new int[n];

        for (int i = 0; i < n; i++)
            powerOfSoldier[i] = scn.nextInt();

        Arrays.sort(powerOfSoldier);

        int[] prefix = new int[n];
        prefix[0] = powerOfSoldier[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + powerOfSoldier[i];


        int Q = scn.nextInt();

        while (Q-- > 0) {

            int power = scn.nextInt();
            power = getNoOFSoldier(powerOfSoldier, power);
            if (power == -1) {
                System.out.println(0 + "  " + 0);
            } else
                System.out.println((power + 1) + " " + prefix[power]);
        }
    }

    public static int getNoOFSoldier(int[] powerOfSoldier, int power) {
        int l = 0;
        int r = powerOfSoldier.length - 1;
        if (power < powerOfSoldier[0])
            return 0;
        int index = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (powerOfSoldier[mid] <= power) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}
