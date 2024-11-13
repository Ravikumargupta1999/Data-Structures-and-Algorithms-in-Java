import java.util.ArrayList;

public class Shuffle_the_Array {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            al.add(nums[i]);
        }
        int k = 0;
        for(int i=0;i<nums.length;i+=2)
        {
            nums[i] = al.get(k++);
            nums[i+1] = al.get(n++) ;
        }
        return nums;
    }
}
