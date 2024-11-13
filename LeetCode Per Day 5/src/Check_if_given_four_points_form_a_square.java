import java.util.HashMap;

public class Check_if_given_four_points_form_a_square {
    int getDistance(int[] A,int[] B){
        return ((B[0] - A[0]) * (B[0] - A[0])) +
                ((B[1] - A[1]) * (B[1] - A[1]));
    }

    int fourPointSquare(int[][] points) {
        HashMap<Integer,Integer> distances = new HashMap<>();

        int d1 = getDistance(points[0], points[1]);
        int d2 = getDistance(points[1], points[2]);
        int d3 = getDistance(points[2], points[3]);
        int d4 = getDistance(points[3], points[0]);
        int d5 = getDistance(points[0], points[2]);
        int d6 = getDistance(points[1], points[3]);

        distances.put(d1,distances.getOrDefault(d1,0)+1);
        distances.put(d2,distances.getOrDefault(d2,0)+1);
        distances.put(d3,distances.getOrDefault(d3,0)+1);
        distances.put(d4,distances.getOrDefault(d4,0)+1);
        distances.put(d5,distances.getOrDefault(d5,0)+1);
        distances.put(d6,distances.getOrDefault(d6,0)+1);



        boolean sides = false;
        boolean diagonals = false;
        for(int it : distances.keySet()){
            if(distances.get(it) == 4) sides = true;
            if(distances.get(it) == 2) diagonals = true;
        }

        return (sides && diagonals) ? 1 : 0;
    }
}
