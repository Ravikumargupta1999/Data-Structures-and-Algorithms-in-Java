import java.util.*;
// https://leetcode.com/problems/subsets/submissions/
// https://practice.geeksforgeeks.org/problems/power-set4302/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=0&page=2&query=category[]Bit%20Magicdifficulty[]0page2category[]Bit%20Magic

public class Power_Set {
    void generatesSubset(int ind,int[] arr,List<Integer> al,List<List<Integer>> al1)
    {
        al1.add(new ArrayList<>(al));
        for(int i=ind;i<arr.length;i++) {
          //  if(i != ind && arr[i] == a)
            //    continue;
            // generatesSubset(i + 1, arr, al, al1);
            al.add(arr[i]);
            generatesSubset(i + 1, arr, al, al1);
            al.remove(al.size() - 1);
        }

    }
    List<String> subsets(String str)
    {
        int[] arr = new int[str.length()];
        for(int i=0;i<arr.length;i++)
            arr[i] = str.charAt(i);
        Arrays.sort(arr);
        List<List<Integer>> al1 = new ArrayList<>();
        generatesSubset(0,arr,new ArrayList<>(),al1);
         List<String> result = new ArrayList<>();
         for(int i=1;i<al1.size();i++)
         {
             String temp = "";
             for(int j=0;j<al1.get(i).size();j++)
             {
                 int l = al1.get(i).get(j);
                 temp = temp + (char)l;
             }
             result.add(temp);

         }
         Collections.sort(result);
        return result;
    }


    public static void main(String[] args) {
        Power_Set a = new Power_Set();
        System.out.println(a.subsets("dmxn"));
    }
}
