import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// https://leetcode.com/problems/permutations/
public class Video_50_Permutation_of_an_array {
    public List<List<Integer>> find_permutation(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        generateWords(1,arr.length,map,new ArrayList<Integer>());

        return ans;
    }
    List<List<Integer>> ans = new ArrayList<>();
    public void generateWords(int cs,int ts,HashMap<Integer,Integer> map,List<Integer> al)
    {
//        System.out.println(al);
        if(cs > ts)
        {

            ans.add(new ArrayList<>(al));
            return;
        }
        for(int ch : map.keySet())
        {
            if(map.get(ch) > 0)
            {
                map.put(ch,map.get(ch)-1);
                al.add(ch);
                generateWords(cs+1,ts,map,al);
                al.remove(al.size()-1);
                map.put(ch,map.get(ch)+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,9};
        Video_50_Permutation_of_an_array a = new Video_50_Permutation_of_an_array();
        System.out.println(a.find_permutation(arr));
    }
}
