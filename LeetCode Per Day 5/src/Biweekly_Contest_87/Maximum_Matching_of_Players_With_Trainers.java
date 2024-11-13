package Biweekly_Contest_87;

import java.util.Arrays;

public class Maximum_Matching_of_Players_With_Trainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // TLE
//        Arrays.sort(players);
//        Arrays.sort(trainers);
//        boolean[] flag = new boolean[trainers.length];
//
//        int count = 0;
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < trainers.length; j++) {
//                if(!flag[j] && trainers[j] >= players[i]){
//                    flag[j] = true;
//                    count++;
//                }
//            }
//        }
//        return count;

        // NO TLE
        Arrays.sort(players);
        Arrays.sort(trainers);
        boolean[] flag = new boolean[trainers.length];

        int count = 0;
        int prev = -1;
        for (int i = 0; i < players.length; i++) {
            for (int j = prev+1 ; j<trainers.length;j++) {
                if(!flag[j] && trainers[j] >= players[i]){
                    prev = i;
                    flag[j] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
