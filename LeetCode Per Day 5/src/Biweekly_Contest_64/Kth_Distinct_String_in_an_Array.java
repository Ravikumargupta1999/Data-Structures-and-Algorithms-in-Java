package Biweekly_Contest_64;

import java.util.HashMap;

public class Kth_Distinct_String_in_an_Array {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String str: arr)
            map.put(str,map.getOrDefault(str,0)+1);
        for (String st : arr){
            if(map.get(st) == 1){
                k--;
                if(k == 0)
                    return st;
            }
        }
        return "";
    }
}
