import java.util.Scanner;

public class Video_2_Climbinng_Stair_case_Memoization {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count_paths = get_count_paths(n,new int[n+1]);
        System.out.println(count_paths);
    }
    public static int get_count_paths(int n,int[] qb)
    {
        if(n == 0)
            return 1;
        else if(n < 0)
            return 0;
        if(qb[n] != 0)
            return qb[n];
        System.out.println("Ravi : "+n);
        int n1 = get_count_paths(n-1,qb);
        int n2 = get_count_paths(n-2,qb);
        int n3 = get_count_paths(n-3,qb);
        int count_paths = n1 + n2 + n3;
        qb[n] = count_paths;
        return count_paths;
    }
}
