import java.util.ArrayList;
import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258/1#
public class Video_40_Smallest_SubArray_with_highest_frequency_element {

    class Pair {
        int freq;
        int start;

        public Pair(int freq, int start) {
            this.freq = freq;
            this.start = start;
        }
    }

    ArrayList<Integer> smallestSubsegment(int[] arr, int n) {
        int hf = 0;
        int start = -1;
        int end = -1;
        int len = 0;

        HashMap<Integer, Pair> frequencyAndStartPoint = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (frequencyAndStartPoint.containsKey(arr[i])) {
                frequencyAndStartPoint.get(arr[i]).freq++;
            } else {
                frequencyAndStartPoint.put(arr[i], new Pair(1, i));
            }
            int freq = frequencyAndStartPoint.get(arr[i]).freq;
            int currLen = i - frequencyAndStartPoint.get(arr[i]).start + 1;
            if(freq < hf){
                continue;
            }
            else if(freq > hf){
                start = frequencyAndStartPoint.get(arr[i]).start;
                end = i;
                hf = frequencyAndStartPoint.get(arr[i]).freq;
                len = currLen;
            }
            else if(freq == hf && currLen < len){
                start = frequencyAndStartPoint.get(arr[i]).start;
                end = i;
                hf = frequencyAndStartPoint.get(arr[i]).freq;
                len = currLen;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = start; i <= end; i++)
            al.add(arr[i]);
        return al;
    }


    public static void main(String[] args) {
        Video_40_Smallest_SubArray_with_highest_frequency_element a = new Video_40_Smallest_SubArray_with_highest_frequency_element();
        int[] arr = {1, 3, 3, 5, 3, 5};
        System.out.println(a.smallestSubsegment(arr, arr.length));
    }
}
