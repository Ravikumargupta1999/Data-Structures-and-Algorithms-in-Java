import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/?category[]=Hash&category[]=Hash&difficulty[]=1&page=2&query=category[]Hashdifficulty[]1page2category[]Hash

public class Overlapping_Intervals {
//    static class Pair {
//        int start;
//        int end;
//    }

    public static int[][] overlappedInterval(int[][] Intervals) {
        Pair[] pairArray = new Pair[Intervals.length];
        for (int i = 0; i < Intervals.length; i++) {
            Pair p = new Pair(Intervals[i][0], Intervals[i][1]);
            pairArray[i] = p;
        }
        Arrays.sort(pairArray);
//        for (int i = 0; i < Intervals.length; i++) {
//            System.out.println(pairArray[i].st + "  " + pairArray[i].end);
//        }
        ArrayList<Pair> al = new ArrayList<>();
        int l = pairArray[0].st;
        int r = pairArray[0].end;
//        System.out.println("for Loop");
        for (int i = 1; i < pairArray.length; i++) {
            if (pairArray[i].st <= r) {
                r = Math.max(pairArray[i].end,r);
            } else {
                al.add(new Pair(l, r));
                l = pairArray[i].st;
                r = pairArray[i].end;
            }
//            System.out.println(l+"  "+r);
        }
        al.add(new Pair(l, r));
//        System.out.println("");
//        System.out.println("");
        int[][] ans = new int[al.size()][2];
        for (int i = 0; i < al.size(); i++) {
//            System.out.println(al.get(i).st + "  " + al.get(i).end);
            ans[i][0] = al.get(i).st;
            ans[i][1] = al.get(i).end;

        }
        return ans;
    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.end - other.end;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{4,7}, {2, 4},{6, 8}, {1, 9}};
        arr= overlappedInterval(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "  " + arr[i][1]);
        }
    }
}
