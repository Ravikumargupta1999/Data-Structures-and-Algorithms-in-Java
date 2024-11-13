import java.util.HashMap;

public class Video_45_Key_Pair {
    // https://practice.geeksforgeeks.org/problems/key-pair5616/1/
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int ele : arr)
            map.put(ele,map.getOrDefault(ele,0)+1);
        for (int ele : arr){
            map.put(ele,map.get(ele)-1);
            if(map.containsKey(x-ele)){
                if(map.get(x-ele) > 1)
                    return true;
            }
            map.put(ele,map.get(ele)+1);
        }
        return false;
    }
}
