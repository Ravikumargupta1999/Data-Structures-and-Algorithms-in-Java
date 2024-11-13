package Day_9_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset_I {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printSubset(nums,0,temp,res);
        return res;
    }
    public void printSubset(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        printSubset(nums,index+1,temp,res);
        temp.remove(temp.size()-1);
        printSubset(nums,index+1,temp,res);
    }
}
