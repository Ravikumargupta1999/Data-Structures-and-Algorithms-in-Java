public class Practice_8_Binary_String {
    // https://practice.geeksforgeeks.org/problems/binary-string-1587115620/1?page=14&company[]=Amazon&sortBy=submissions
    //Function to count the number of substrings that start and end with 1.
    public static int binarySubstring(int a, String str) {

        int count1 = 0;

        int ans = 0;
        for (char ch : str.toCharArray()){
            if(ch != '0'){
                ans += count1;
                count1++;
            }
        }
        return count1;

    }
}
