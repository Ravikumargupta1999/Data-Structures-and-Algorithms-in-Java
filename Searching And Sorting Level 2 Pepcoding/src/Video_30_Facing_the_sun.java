public class Video_30_Facing_the_sun {
    // https://practice.geeksforgeeks.org/problems/facing-the-sun2126/1
    int countBuildings(int h[], int n) {
        int max = h[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (h[i] > max) {
                max = h[i];
                count++;
            }
        }
        return count;
    }
}
