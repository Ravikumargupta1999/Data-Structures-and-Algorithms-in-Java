import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon

public class Permutation_with_Spaces {
   static ArrayList<String> permutation(String n){
       ArrayList<String>al = new ArrayList<>();
       if(n.length() == 0)
           return new ArrayList<>();
       if(n.length() == 1)
       {
           al.add(""+n.charAt(0));
           return al;
       }
       printPermutation(n.substring(1),n.charAt(0)+"",al);
       System.out.println(al.size());
       return al;

    }
    static void printPermutation(String input, String output, ArrayList<String> al)
    {
        if(input.length() == 1)
        {
            al.add(output+" "+input.charAt(0));
            al.add(output+input.charAt(0));
            return;
        }
        printPermutation(input.substring(1),output+" "+input.charAt(0),al);
        printPermutation(input.substring(1),output+input.charAt(0),al);

    }

    public static void main(String[] args) {
        System.out.println(permutation("ABDdhh"));
    }
}
