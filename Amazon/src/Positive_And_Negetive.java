import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/positive-and-negative-elements4613/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=8&query=category[]Arrayscompany[]Amazonpage8company[]Amazoncategory[]Arrays#

public class Positive_And_Negetive {

    ArrayList<Long> arranged(long arr[], int n)
    {
        int positive = 0;
        int negative = 1;
        while (true)
        {
            if(positive < n && arr[positive] >=0)
                positive +=2;
            if(negative < n && arr[negative]<0)
                negative +=2;
            if(positive < n && negative < n)
            {
                long temp = arr[positive];
                arr[positive] = arr[negative];
                arr[negative] = temp;
            }
            else
                break;

        }
        ArrayList<Long> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(arr[i]);
        }
        return al;


    }

}
