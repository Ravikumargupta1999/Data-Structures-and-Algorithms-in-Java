import java.util.ArrayList;
import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/even-and-odd-elements-at-even-and-odd-positions1342/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=7&query=category[]Arrayscompany[]Amazonpage7company[]Amazoncategory[]Arrays#
// https://practice.geeksforgeeks.org/problems/even-and-odd/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=8&query=category[]Arrayscompany[]Amazonpage8company[]Amazoncategory[]Arrays#
// Solution is same as " Alternate positive and negative numbers "
// https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1/?company[]=Amazon&company[]=Amazon&problemStatus=solved&difficulty[]=0&page=5&query=company[]AmazonproblemStatussolveddifficulty[]0company[]Amazonpage5

public class Even_And_Odd {


    ArrayList<Long> arrangeOddAndEven(long arr[], int n)
    {
        ArrayList<Long> al1 = new ArrayList<>();
        ArrayList<Long> al2 = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            if(arr[i]%2 == 0)
                al1.add(arr[i]);
            else
                al2.add(arr[i]);
        }
        int i =0;
        int k =0;
        int j = 0;
        while (i<al1.size() || j<al2.size())
        {
            if(i<al1.size()) {
                arr[k++] = al1.get(i++);
            }
            if(j<al2.size()) {
                arr[k++] = al2.get(j++);
            }
        }
        ArrayList<Long> al = new ArrayList<>();
        for(int l = 0;l<arr.length;l++)
        {
            al.add(arr[i]);
        }
        return al;
    }
    public static void main(String[] args) {


    }
}
