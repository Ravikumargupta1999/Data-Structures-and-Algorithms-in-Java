import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class Subsets_II_Leetcode {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> al = new ArrayList<>();
        findSubsets(0,nums,new ArrayList<>(),al);
        return al;
    }
    public void findSubsets(int ind,int[] arr,List<Integer> al,List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(al));
        for(int i=ind ;i<arr.length;i++)
        {
            if(i != ind && arr[i] == arr[i-1])
                continue;
            al.add(arr[i]);
            findSubsets(i+1,arr,al,ans);
            al.remove(al.size()-1);
        }
    }


    // End Leetcode


    // Gfg
    //Function to find all possible unique subsets.
    // https://practice.geeksforgeeks.org/problems/subsets-1587115621/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Backtracking&query=company[]Amazonpage1company[]Amazoncategory[]Backtracking

    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        Arrays.sort(arr);
        ArrayList <ArrayList <Integer>> al = new ArrayList<>();
        findSubset(0,arr,new ArrayList<>(),al);
        al.remove(0);
        return al;

    }
    public static void findSubset(int ind,int[] arr,List<Integer> al,ArrayList<ArrayList<Integer>> ans)
    {
        ans.add(new ArrayList<>(al));
        for(int i=ind ;i<arr.length;i++)
        {
            if(i != ind && arr[i] == arr[i-1])
                continue;
            al.add(arr[i]);
            findSubset(i+1,arr,al,ans);
            al.remove(al.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(AllSubsets(new int[]{2,1,2},3));
    }
}
