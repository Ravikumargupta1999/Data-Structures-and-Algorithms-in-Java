import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/positive-and-negative-elements4613/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=4&query=company[]Amazondifficulty[]-1page4company[]Amazon#

public class Positive_and_negative_elements {
    ArrayList<Long> arranged(long arr[], int n)
    {
        ArrayList<Long> al1 = new ArrayList<>();
        ArrayList<Long> al2 = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(arr[i] < 0)
                al2.add(arr[i]);
            else
                al1.add(arr[i]);
        ArrayList<Long> al = new ArrayList<>();
        for(int i=0;i<al1.size();i++)
        {
            al.add(al1.get(i));
            al.add(al2.get(i));
        }
        return al;

    }
}
