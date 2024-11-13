import java.util.Arrays;

public class HH {
    static void search(int no_of_mobiles, int[][] price_and_speed, int Q, int[][] queries) {
        Arrays.sort(price_and_speed, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        for (int[] q : queries ){
            int count = 0;
            for(int[] p : price_and_speed){
                if(p[0] >= q[0] && p[1] <= q[1]){
                    count++;
                }
            }
            System.out.println(count +" mobiles are available");
            
        }

    }
}
