package Biweekly_Contest_62;

public class Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j]).equals(target))
                    count++;
            }
        }
        return count;
    }

}
