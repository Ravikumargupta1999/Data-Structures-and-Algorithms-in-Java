//https://practice.geeksforgeeks.org/problems/palindrome-pairs/1/?company[]=Amazon&company[]=Amazon&difficulty[]=2&page=2&query=company[]Amazondifficulty[]2page2company[]Amazon

public class Palindromic_Pairs {
    static int palindromepair(int N, String arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isPalindriome(arr[i] + arr[j])) {
                    // System.out.println(arr[i]+"  "+arr[j]);
                    return 1;
                }
                if (isPalindriome(arr[j] + arr[i])) ;
                return 1;
            }
        }
        return 0;
    }


    static boolean isPalindriome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String arr[] = {};
        System.out.println(palindromepair(arr.length, arr));

    }
}
