package Weekly_Contest_322;

public class Circular_Sentence {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        for (int i=0;i<arr.length-1;i++){
            String s1 = arr[i];
            String s2 = arr[i+1];
            if(s1.charAt(s1.length()-1) != s2.charAt(0))
                return false;
        }
        return arr[0].charAt(0) == arr[arr.length-1].charAt(arr[arr.length-1].length()-1);
    }
}
