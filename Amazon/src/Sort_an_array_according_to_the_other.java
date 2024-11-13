import java.util.*;

// https://practice.geeksforgeeks.org/problems/relative-sorting4323/1/?category[]=Hash&category[]=Hash&page=2&query=category[]Hashpage2category[]Hash

public class Sort_an_array_according_to_the_other {
    public static int[] sortA1ByA2(int a1[], int n, int a2[], int m)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< n;i++)
            map.put(a1[i],map.getOrDefault(a1[i],0)+1);
        ArrayList<Integer> al1 = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            if(map.containsKey(a2[i]))
            {
                for(int j=0;j<map.get(a2[i]);j++)
                    al1.add(a2[i]);
                map.remove(a2[i]);
            }
        }
        ArrayList<Integer> al2 = new ArrayList<>();
        for (Map.Entry mapElement : map.entrySet()) {
            int key = (int) mapElement.getKey();
            int value = ((int) mapElement.getValue());
            for (int i=0;i<value;i++)
                al2.add(key);
        }
        Collections.sort(al2);
//        System.out.println(al1);
//        System.out.println(al2);
//        System.out.println(al1.size());
//        System.out.println(al2.size());
        int k = 0;
        for(int i=0;i<al1.size();i++)
            a1[k++] = al1.get(i);
        for(int i=0;i<al2.size();i++)
            a1[k++] = al2.get(i);

        return a1;
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 4;
        int a1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int a2[] = {99, 22, 444, 56};
        sortA1ByA2(a1,a1.length,a2,a2.length);
        for (int i=0;i<a1.length;i++)
            System.out.print(a1[i]+"  ");
        System.out.println("");
    }
}
