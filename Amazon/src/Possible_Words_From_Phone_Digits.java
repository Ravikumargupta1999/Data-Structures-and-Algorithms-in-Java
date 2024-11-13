import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
//https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Arrayscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Arrays#

public class Possible_Words_From_Phone_Digits {
    //Function to find list of all words possible by pressing given numbers.
    // Brute force
    // Working too
    static ArrayList<String> possibleWords(int arr[], int n)
    {
        ArrayList<String> al = new ArrayList<>();
        solve(arr,0,al,"");
        Collections.sort(al);
        return al;
    }
    public static void solve(int[] arr,int i,ArrayList<String> al,String res) {
        if (i == arr.length) {
            al.add(res);
            return;
        }
        if (arr[i] == 2) {
            solve(arr, i + 1, al, res + "a");
            solve(arr, i + 1, al, res + "b");
            solve(arr, i + 1, al, res + "c");
        }
        if (arr[i] == 3) {
            solve(arr, i + 1, al, res + "d");
            solve(arr, i + 1, al, res + "e");
            solve(arr, i + 1, al, res + "f");
        }
        if (arr[i] == 4) {
            solve(arr, i + 1, al, res + "g");
            solve(arr, i + 1, al, res + "h");
            solve(arr, i + 1, al, res + "i");
        }
        if (arr[i] == 5) {
            solve(arr, i + 1, al, res + "j");
            solve(arr, i + 1, al, res + "k");
            solve(arr, i + 1, al, res + "l");
        }
        if (arr[i] == 6) {
            solve(arr, i + 1, al, res + "m");
            solve(arr, i + 1, al, res + "n");
            solve(arr, i + 1, al, res + "o");
        }
        if (arr[i] == 7) {
            solve(arr, i + 1, al, res + "p");
            solve(arr, i + 1, al, res + "q");
            solve(arr, i + 1, al, res + "r");
            solve(arr, i + 1, al, res + "s");


        }
        if (arr[i] == 8) {

            solve(arr, i + 1, al, res + "t");
            solve(arr, i + 1, al, res + "u");
            solve(arr, i + 1, al, res + "v");
        }
        if (arr[i] == 9) {
            solve(arr, i + 1, al, res + "w");
            solve(arr, i + 1, al, res + "x");
            solve(arr, i + 1, al, res + "y");
            solve(arr, i + 1, al, res + "z");

        }
    }


    // Better Approach not better actually same approach
    static ArrayList<String> possibleWords1(int arr[], int n)
    {
        String str = "";
        for(int i=0;i<n;i++)
        {
            str += (""+arr[i]);
        }
        System.out.println(str);
        if(n == 0)
            return new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        solve1(al,str,"",0,map);
        Collections.sort(al);
        return al;
    }
    public static void solve1(ArrayList<String> al,String digit,String current,int i,String[] map)
    {
        if( i == digit.length())
        {
            al.add(current);
            return;
        }
        String letter = map[digit.charAt(i)-'0'];
        for(int j = 0;j < letter.length();j++)
            solve1(al,digit,current + letter.charAt(j),i+1,map);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4};
        System.out.println(possibleWords(arr,arr.length));
        System.out.println(possibleWords1(arr,arr.length));
    }
}
