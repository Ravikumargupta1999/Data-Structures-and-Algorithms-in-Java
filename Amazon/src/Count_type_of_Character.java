
//https://practice.geeksforgeeks.org/problems/count-type-of-characters3635/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-2&page=1&query=company[]Amazondifficulty[]-2page1company[]Amazon

public class Count_type_of_Character {
    int[] fun(String str)
    {
        int[] arr = new int[4];
        for(int i=0;i<str.length();i++) {

            if (str.charAt(i) >= 65 && str.charAt(i) <=90)
                arr[0]+=1;
            else if(str.charAt(i) >= 97 && str.charAt(i) <=122)
                arr[1] += 1;
            else if(str.charAt(i) >= 48 && str.charAt(i) <=57)
                arr[2] += 1;
            else
                arr[3] +=1;
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
