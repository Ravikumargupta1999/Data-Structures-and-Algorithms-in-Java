import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
// Sumit malik ka solution nahi accept hua tha use dekh lena then gfg article karna

// https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/?category[]=Strings&category[]=Strings&difficulty[]=2&page=1&query=category[]Stringsdifficulty[]2page1category[]Strings#
// https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/

public class All_Possible_Palindrome_Partitiong {
    public static void main(String[] args)
    {
        String input = "nitin";

        System.out.println("All possible palindrome" +
                "partitions for " + input
                + " are :");

        allPalPartitions(input);
    }


    private static ArrayList<ArrayList<String>> allPalPartitions(String input)
    {
        int n = input.length();
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();
        Deque<String> currPart = new LinkedList<>();
        allPalPartitonsUtil(allPart, currPart, 0, n, input);
        return allPart;


    }

    private static void allPalPartitonsUtil(ArrayList<ArrayList<String>> allPart, Deque<String> currPart, int start, int n, String input)
    {
        if (start >= n)
        {
            allPart.add(new ArrayList<>(currPart));
            return;
        }
        for (int i = start; i < n; i++)
        {
            if (isPalindrome(input, start, i))
            {
                currPart.addLast(input.substring(start, i + 1));
                allPalPartitonsUtil(allPart, currPart, i + 1, n, input);
                currPart.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String input, int start, int i) {
        while (start < i) {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }
}
