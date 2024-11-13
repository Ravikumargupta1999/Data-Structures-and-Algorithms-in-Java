import java.util.Arrays;
import java.util.Comparator;

public class Greedy_251_N_Meeting_In_One_Room {
    static class Pair
    {
        int first ;
        int second ;
        int pos;
        public Pair(int first,int second,int pos)
        {
            this.first = first;
            this.second = second;
            this.pos = pos;
        }
    }
    public static int maxMeetings(int start[], int end[], int n) {
        Pair[] arr = new Pair[n];
        for (int i=0;i<n;i++)
        {
            Pair p = new Pair(start[i],end[i],(i+1));
            arr[i] = p;
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.second- o2.second;
            }
        });

        int count = 1;
        System.out.println(arr[0].pos+"  "+arr[0].first+"  "+arr[0].second);
        int last = arr[0].second;
        for(int i=1;i<n;i++)
        {
            if(arr[i].first>last)
            {
                count++;
                System.out.println(arr[i].pos+"  "+arr[i].first+"  "+arr[i].second);
                last = arr[i].second;

            }
        }
        return count;

    }
    public static void main(String[] args) {
        int n = 3;
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] =  { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(start,end,end.length));
    }

}
