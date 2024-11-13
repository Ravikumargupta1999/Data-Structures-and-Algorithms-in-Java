import java.util.*;

// https://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/
public class BST_231_N_Meetings_In_One_Room {
    static class Pair {
        int start;
        int end;


        public Pair(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Pair> array = new ArrayList<Pair>();
        for(int i =0;i<n;i++)
        {
            array.add(new Pair(start[i],end[i]));
        }
        Collections.sort(array, new Comparator<Pair>()
                {
                    @Override
                    public int compare(Pair o1, Pair o2)
                    {
                        Integer i1 = (Integer) o1.start;
                        Integer i2 = (Integer) o2.start;
                        return i1.compareTo(i2);
                    }
                }
        );
        for(int i=0;i<array.size();i++)
        {
            System.out.println(array.get(i).start+"   "+array.get(i).end);
        }
        System.out.println("");
        System.out.println("");

        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int j=1;j<array.size();j++)
        {
            int i =j;
            while (i<array.size())
            {
                if(array.get(j-1).end>=array.get(i).start &&  hm.containsKey(i) == false)
                {
                    hm.put(i,1);
                    System.out.println(i+"  "+array.get(i).start+"   "+array.get(i).end);
                    count++;
                    i++;
                }
                else {
                    break;
                }
            }
        }
        return count;


    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr1 = new int[n];
        System.out.println("");
        for(int i=0;i<n;i++)
            arr1[i] = s.nextInt();
        System.out.println("");

        int[] arr2 = new int[n];
        System.out.println("");
        for(int i=0;i<n;i++)
            arr2[i] = s.nextInt();
        System.out.println("");

        for(int i=0;i<n;i++)
            System.out.print(arr1[i]+"  ");
        System.out.println("");
        for(int i=0;i<n;i++)
            System.out.print(arr2[i]+"  ");
        System.out.println("");


        int value = maxMeetings(arr1,arr2,n);
        System.out.println(value);



    }
}
//N = 6
//S[] = {1,3,0,5,8,5}
// F[] = {2,4,6,7,9,9}

// [[4,5], [2,3], [3,6], [5,7], [7,8]]