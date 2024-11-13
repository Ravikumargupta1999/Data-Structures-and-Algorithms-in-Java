package One;

import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/#
public class Possible_Words_From_Phone_Digits {
    static ArrayList <String> possibleWords(int arr[], int N)
    {
        char[][] num = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++)
            list.add(new ArrayList<>());
        for (int i = 2; i <= 9; i++){
            for (int j = 0 ;j < num[i-2].length;j++){
                list.get(i).add(num[i-2][j]);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        possibleCombination(arr,0,N,"",ans,list);

        return ans;
    }
    public static void possibleCombination(int[] arr,int index,int n,String str,ArrayList<String> ans,ArrayList<ArrayList<Character>> list){
        if(index == arr.length){
            ans.add(str);
            return;
        }
//        System.out.println(str);
        for (char ch : list.get(arr[index])){
            possibleCombination(arr,index+1,n,str+ch,ans,list);
        }
    }
}
