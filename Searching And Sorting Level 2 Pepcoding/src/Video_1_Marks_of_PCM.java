import java.util.Comparator;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/marks-of-pcm2529/1
public class Video_1_Marks_of_PCM {
    class Pair {
        int phy;
        int chem;
        int maths;

        public Pair(int phy, int chem, int maths) {
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }
    }

    public void customSort(int phy[], int chem[], int math[], int n) {
        Pair[] res = new Pair[n];
        for (int i = 0; i < n; i++)
            res[i] = new Pair(phy[i], chem[i], math[i]);
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.phy != o2.phy)
                    return o1.phy - o2.phy;
                else if (o1.chem != o2.chem)
                    return o2.chem - o1.chem;
                else
                    return o1.maths - o2.maths;
            }
        });
        for (int i = 0; i < n; i++)
            pq.add(res[i]);
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        for (int j = 0; j < n; j++) {
            phy[j] = res[j].phy;
            chem[j] = res[j].chem;
            math[j] = res[j].maths;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int phy[] = {4, 1, 10, 4, 4, 4, 1, 10, 1, 10};
        int chem[] = {5, 2, 9, 6, 3, 10, 2, 9, 14, 10};
        int math[] = {12, 3, 6, 5, 2, 10, 16, 32, 10, 4};
        Video_1_Marks_of_PCM a = new Video_1_Marks_of_PCM();
        a.customSort(phy, chem, math, n);
        for (int i = 0; i < n; i++) {
            System.out.println(phy[i] + "   " + chem[i] + "   " + math[i]);
        }

    }
}
