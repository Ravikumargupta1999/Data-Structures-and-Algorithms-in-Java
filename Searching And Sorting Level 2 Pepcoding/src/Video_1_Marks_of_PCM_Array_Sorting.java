import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/marks-of-pcm2529/1#
public class Video_1_Marks_of_PCM_Array_Sorting {
    static class Marks implements Comparable<Marks> {
        int phy;
        int chem;
        int math;


        public Marks(int phy, int chem, int math) {
            this.phy = phy;
            this.chem = chem;
            this.math = math;
        }

        public int compareTo(Marks o) {
            if (this.phy != o.phy)
                return this.phy - o.phy;
            else if (this.chem != o.chem)
                return o.chem - this.chem;
            else
                return this.math - o.math;
        }
    }

    public void customSort(int[] phy, int[] chem, int[] math, int n) {
        Marks[] arr = new Marks[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Marks(phy[i], chem[i], math[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            Marks p = arr[i];
            math[i] = p.math;
            chem[i] = p.chem;
            phy[i] = p.phy;

        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] phy = {4, 1, 10, 4, 4, 4, 1, 10, 1, 10};
        int[] chem = {5, 2, 9, 6, 3, 10, 2, 9, 14, 10};
        int[] math = {12, 3, 6, 5, 2, 10, 16, 32, 10, 4};
        Video_1_Marks_of_PCM_Array_Sorting a = new Video_1_Marks_of_PCM_Array_Sorting();
        a.customSort(phy, chem, math, n);
        for (int i = 0; i < n; i++) {
            System.out.println(phy[i] + "   " + chem[i] + "   " + math[i]);
        }
    }
}
